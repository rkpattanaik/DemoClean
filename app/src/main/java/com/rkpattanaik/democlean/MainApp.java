package com.rkpattanaik.democlean;

import android.app.Application;

import com.rkpattanaik.democlean.di.component.AppComponent;
import com.rkpattanaik.democlean.di.component.DaggerAppComponent;
import com.rkpattanaik.democlean.di.module.AppModule;


/**
 * @author Rajesh Pattanaik
 */

public class MainApp extends Application {
    private static MainApp sInstance;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        createAppComponent();
    }

    public static MainApp getInstance() {
        return sInstance;
    }

    private void createAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
