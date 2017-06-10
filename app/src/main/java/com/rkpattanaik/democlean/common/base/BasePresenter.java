package com.rkpattanaik.democlean.common.base;

/**
 * Base Presenter which is extended by other presenters.
 *
 * @author Rajesh Pattanaik
 */

public abstract class BasePresenter<V extends Mvp.View> implements Mvp.Presenter<V> {

    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
        onViewAttached();
    }

    protected abstract void onViewAttached();

    @Override
    public void detachView() {
        mMvpView = null;
        onViewDetached();
    }

    protected void onViewDetached() {}

    protected V view() {
        return mMvpView;
    }
}
