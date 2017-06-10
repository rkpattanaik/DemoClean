package com.rkpattanaik.democlean.common.base;

/**
 * Created by RP00335231
 *
 * MVP interface contains the base Model, View & Presenter interfaces.
 */

public interface Mvp {

    interface Model {

    }

    interface View {

    }

    interface Presenter<V extends Mvp.View> {
        void attachView(V mvpView);
        void detachView();
    }
}
