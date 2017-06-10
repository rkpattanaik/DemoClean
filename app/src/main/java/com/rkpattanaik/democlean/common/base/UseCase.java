package com.rkpattanaik.democlean.common.base;


import com.rkpattanaik.democlean.common.executor.ExecutorThread;
import com.rkpattanaik.democlean.common.executor.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link Subscriber}
 * that will execute its job in a background thread and will post the result in the UI thread.
 *
 * @author Rajesh Pattanaik
 */

public abstract class UseCase<T> implements Interactor<T> {

    private final ExecutorThread executorThread;
    private final PostExecutionThread postExecutionThread;
    private Subscription subscription = Subscriptions.empty();

    public UseCase(ExecutorThread executorThread, PostExecutionThread postExecutionThread) {
        this.executorThread = executorThread;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    public abstract Observable<T> createObservable();

    @Override
    public void execute(Subscriber<T> subscriber) {
        this.subscription = createObservable()
                .subscribeOn(executorThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    @Override
    public Observable<T> execute() {
        return createObservable();
    }

    /**
     * Unsubscribes from current {@link Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
