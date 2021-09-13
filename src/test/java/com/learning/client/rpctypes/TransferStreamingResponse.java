package com.learning.client.rpctypes;

import com.learning.models.TransferResponse;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class TransferStreamingResponse implements StreamObserver<TransferResponse> {

    private CountDownLatch latch;

    public TransferStreamingResponse(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onNext(TransferResponse transferResponse) {
        System.out.println("Status :" + transferResponse.getStatus());
        transferResponse.getAccountsList().stream()
                .map(account -> account.getAccountId() + " : " + account.getAmount())
                .forEach(System.out::println);
        System.out.println("----------------------");
    }

    @Override
    public void onError(Throwable throwable) {
        this.latch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("All Transfers done!!");
        this.latch.countDown();
    }
}
