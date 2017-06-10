package com.rkpattanaik.democlean.home.di;

import android.app.Activity;

import com.rkpattanaik.democlean.di.scope.ActivityScope;
import com.rkpattanaik.democlean.home.presentation.HomeContract;
import com.rkpattanaik.democlean.home.presentation.HomePresenter;
import com.rkpattanaik.democlean.home.presentation.ItemsAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * This is a dagger module responsible for
 * {@link com.rkpattanaik.democlean.home.presentation.HomeActivity}.
 *
 * @author Rajesh Pattanaik
 */

@Module
public class HomeActivityModule {
    private Activity mContext;

    public HomeActivityModule(Activity context) {
        mContext = context;
    }

    /**
     * This method provides {@link HomePresenter}.
     * Scope of this object is limit to {@link com.rkpattanaik.democlean.home.presentation.HomeActivity}.
     * @return {@link HomeContract.Presenter}
     */
    @ActivityScope
    @Provides
    public HomeContract.Presenter provideHomePresenter(HomePresenter presenter) {
        return presenter;
    }

    /**
     * This method provides {@link ItemsAdapter}.
     * Scope of this object is limit to {@link com.rkpattanaik.democlean.home.presentation.HomeActivity}.
     * @return {@link ItemsAdapter}
     */
    @ActivityScope
    @Provides
    public ItemsAdapter provideItemsAdapter() {
        return new ItemsAdapter(mContext);
    }
}
