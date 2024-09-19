package com.shyam.diadapter.services;

import com.shyam.diadapter.DataServiceGrpc;
import com.shyam.diadapter.DataServiceProto;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
public class GrpcClientService {

    private final DataServiceGrpc.DataServiceBlockingStub grpcStub;

    public GrpcClientService() {
        val ch = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .maxInboundMessageSize(1024 * 1024 * 1024)
                .build();

        log.info("SKC123::ch::");
        this.grpcStub = DataServiceGrpc.newBlockingStub(ch);
    }

    public byte[] fromPython(String requestId, String query) {

        DataServiceProto.DataRequest request = DataServiceProto.DataRequest.newBuilder()
                .setRequestId(requestId)
                .setQuery(query)
                .build();

        LocalDateTime start = LocalDateTime.now();

        DataServiceProto.DataResponse response = grpcStub.processData(request);
        LocalDateTime end = LocalDateTime.now();
        log.info("SKC: DA consumed:: {}", start.until(end, ChronoUnit.SECONDS));

        return response.getData().toByteArray();
    }
}
