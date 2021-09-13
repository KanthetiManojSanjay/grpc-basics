package com.learning.server.rpctypes;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.Executors;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(6565)
                // By Default Cache thread pool is used
//                .directExecutor() // to make worker threads perform the actual task execution
//                .executor(Executors.newFixedThreadPool(20)) // to create fixed no of threads and make them handle task execution
                .addService(new BankService())
                .addService(new TransferService())
                .build();

        server.start();
        server.awaitTermination();
    }
}
