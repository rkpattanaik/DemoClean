package com.rkpattanaik.democlean.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.rkpattanaik.democlean.data.repository.ItemsRepository;
import com.rkpattanaik.democlean.data.repository.ItemsRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is the Dagger Module which provides application level dependencies.
 * Those objects which need to be created once (i.e Singleton objects) should be provided here.
 *
 * @author Rajesh Pattanaik
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    /**
     * This method provides the app level Context object
     * @return {@link Context}
     */
    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    /**
     * Provides a Singleton instance of {@link Gson}
     * @return {@link Gson}
     */
    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }


    /**
     * This method provides the {@link ItemsRepository} implementation.
     * {@link ItemsRepositoryImpl} is not provided from any module.
     * But as we have added @Inject annotation to the constructor
     * of {@link ItemsRepositoryImpl} class, this class becomes a part
     * of the dependency graph. And when requested for an instance, Dagger
     * provides this instance from the graph to the client.
     *
     * @return {@link ItemsRepository}
     */
    @Singleton
    @Provides
    public ItemsRepository provideItemsRepository(ItemsRepositoryImpl itemsRepository) {
        return itemsRepository;
    }
}
