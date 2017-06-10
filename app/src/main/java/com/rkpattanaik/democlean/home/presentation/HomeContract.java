package com.rkpattanaik.democlean.home.presentation;


import com.rkpattanaik.democlean.common.base.Mvp;
import com.rkpattanaik.democlean.data.model.Item;

import java.util.List;

/**
 * This is the contract for the presenter and view
 * for HomeActivity
 *
 * @author Rajesh Pattanaik
 */

public interface HomeContract {

    interface Presenter extends Mvp.Presenter<HomeContract.View> {
        void onRefreshed();
    }

    interface View extends Mvp.View {
        void hideSwipeRefreshLoading();
        void setCurrentJsonFileNo(int currentJsonFileNo);
        int getCurrentJsonFileNo();
        void showItems(List<Item> items);
        void showError(String message);
    }

}
