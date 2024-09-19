package com.shyam.diadapter.controllers;

import com.shyam.diadapter.model.DAConfig;
import com.shyam.diadapter.services.GrpcClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataController {

    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/fetch-data")
    public ResponseEntity<String> fetchDataFromPython(@RequestParam String requestId, @RequestParam String query) {
        log.info("Shyam11:{}", requestId);
        byte[] responseData = grpcClientService.fromPython(requestId, query);
        String dataString = new String(responseData);

        // return null;
        return ResponseEntity.ok(dataString);
    }

    @PostMapping("/config/{id}")
    public ResponseEntity<Object> persistConfig(
            @PathVariable("id") final String jobId,
            @RequestBody final String config) {
          //  @RequestBody final DAConfig config) {

      //  return null;
        byte[] responseData = grpcClientService.fromPython(jobId, config);
        String dataString = new String(responseData);

        // return null;
        return ResponseEntity.ok(dataString);
    }

    @PostMapping("/start")
    public ResponseEntity<Object> start(
            @PathVariable("jobId") final String jobId) {
        return null;
    }

    @GetMapping("/job-status")
    public ResponseEntity<Object> status(
            @PathVariable("jobId") final String jobId) {
        return null;
    }

    @GetMapping("/status")
    public ResponseEntity<Object> status(
            @PathVariable("startTime") final String startTime,
            @PathVariable("endTime") final String endTime) {

        return null;
    }
}
