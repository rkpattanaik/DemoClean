package com.rkpattanaik.democlean.home.di;

import com.rkpattanaik.democlean.di.scope.ActivityScope;
import com.rkpattanaik.democlean.home.presentation.HomeActivity;

import dagger.Subcomponent;

/**
 * @author Rajesh Pattanaik
 */

@ActivityScope
@Subcomponent(modules = {HomeActivityModule.class})
public interface HomeActivityComponent {
    /**
     * {@link HomeActivity} is the client of this component.
     */
    void inject(HomeActivity homeActivity);
}
