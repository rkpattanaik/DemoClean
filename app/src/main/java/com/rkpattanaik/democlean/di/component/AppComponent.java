package com.rkpattanaik.democlean.di.component;

import com.rkpattanaik.democlean.di.module.AppModule;
import com.rkpattanaik.democlean.di.module.ThreadModule;
import com.rkpattanaik.democlean.home.di.HomeActivityComponent;
import com.rkpattanaik.democlean.home.di.HomeActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This is a Dagger app level component.
 * Component acts like a bridge between dagger module and its clients.
 *
 * @author Rajesh Pattanaik
 */

@Singleton
@Component(modules = {AppModule.class, ThreadModule.class})
public interface AppComponent {
    /**
     * AppComponent provides the dependencies from AppModule and ThreadModule
     * to HomeActivityComponent through this method. So that all the dependencies
     * from AppModule and ThreadModule will be available to HomeActivity.
     *
     * @return {@link HomeActivityComponent}
     */
    HomeActivityComponent plus(HomeActivityModule homeActivityModule);
}
