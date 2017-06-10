package com.rkpattanaik.democlean.common.executor;

import rx.Scheduler;

/**
 * Post execution thread (normally main thread)
 *
 * @author Rajesh Pattanaik
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
