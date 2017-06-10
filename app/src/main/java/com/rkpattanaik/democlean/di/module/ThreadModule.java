package com.rkpattanaik.democlean.di.module;


import com.rkpattanaik.democlean.common.executor.BackgroundThread;
import com.rkpattanaik.democlean.common.executor.ExecutorThread;
import com.rkpattanaik.democlean.common.executor.PostExecutionThread;
import com.rkpattanaik.democlean.common.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Rajesh Pattanaik
 */

@Module
public class ThreadModule {
    @Singleton
    @Provides
    public ExecutorThread provideExecutorThread(BackgroundThread backgroundThread) {
        return backgroundThread;
    }

    @Singleton
    @Provides
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
