package com.rkpattanaik.democlean.common.executor;

import rx.Scheduler;

/**
 * Thread Executor provides the thread on which the task will be executed.
 *
 * @author Rajesh Pattanaik
 */

public interface ExecutorThread {
    Scheduler getScheduler();
}
