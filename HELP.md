# Getting Started

### Reference Documentation

1. Create spring boot application.
2. integrate gRPC and protobuf OSS.
3. install protoc ::
   1. Download the latest protoc version (currently 3.21.x or higher). For instance:
      * curl -OL https://github.com/protocolbuffers/protobuf/releases/download/v28.1/protoc-28.1-osx-x86_64.zip
      * unzip protoc-3.21.1-osx-x86_64.zip -d protoc3
      * sudo mv protoc3/bin/protoc /usr/local/bin/ 
      * protoc --version
   * OR
   2. brew install protobuf
      * protoc --version
      * 


4.  create proto file (data_service.proto) and run below command from same location : 
 #### protoc -I=. --java_out=src/main/java --grpc-java_out=src/main/java data_service.proto

