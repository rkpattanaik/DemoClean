package com.rkpattanaik.democlean.common.executor;

import javax.inject.Inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * This class executes the job in a new background thread.
 *
 * @author Rajesh Pattanaik
 */

public class BackgroundThread implements ExecutorThread {
    @Inject
    public BackgroundThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.newThread();
    }
}
