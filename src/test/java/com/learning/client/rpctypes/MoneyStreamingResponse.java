package com.learning.client.rpctypes;

import com.learning.client.metadata.ClientConstants;
import com.learning.models.Money;
import com.learning.models.WithdrawError;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class MoneyStreamingResponse implements StreamObserver<Money> {

    private CountDownLatch latch;

    public MoneyStreamingResponse(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onNext(Money money) {
        System.out.println("Received async :" + money);
    }

    @Override
    public void onError(Throwable throwable) {
//        Status status = Status.fromThrowable(throwable);
        Metadata metadata = Status.trailersFromThrowable(throwable);
        WithdrawError withdrawError = metadata.get(ClientConstants.WITHDRAW_ERROR_KEY);
//        System.out.println(throwable.getMessage());
        System.out.println(withdrawError.getAmount() + ":" + withdrawError.getErrorMessage());
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Server is done!!");
        latch.countDown();
    }
}
