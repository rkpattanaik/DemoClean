package com.rkpattanaik.democlean.common.executor;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Implementation of PostExecutionThread which provides Android Main Thread or UI Thread.
 *
 * @author Rajesh Pattanaik
 */

public class UIThread implements PostExecutionThread {
    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
