package com.rkpattanaik.democlean.home.presentation;


import com.rkpattanaik.democlean.common.base.BasePresenter;
import com.rkpattanaik.democlean.data.model.Item;
import com.rkpattanaik.democlean.home.domain.GetItemsUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Rajesh Pattanaik
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    private GetItemsUseCase mGetItemsUseCase;
    private int mFileNo;

    @Inject
    HomePresenter(GetItemsUseCase getItemsUseCase) {
        mGetItemsUseCase = getItemsUseCase;
    }

    @Override
    protected void onViewAttached() {
        mFileNo = view().getCurrentJsonFileNo();
        mGetItemsUseCase.setCurrentJsonFile(mFileNo);
        mGetItemsUseCase.execute(new GetItemsSubscriber());
    }

    @Override
    protected void onViewDetached() {
        super.onViewDetached();
        mGetItemsUseCase.unsubscribe();
    }

    @Override
    public void onRefreshed() {
         mFileNo = view().getCurrentJsonFileNo();

        if (mFileNo != 6) mFileNo = mFileNo + 1;
        else mFileNo = 1;

        mGetItemsUseCase.setCurrentJsonFile(mFileNo);
        mGetItemsUseCase.execute(new GetItemsSubscriber());
    }

    // Rx Subscriber for GetItemsUseCase
    private class GetItemsSubscriber extends rx.Subscriber<List<Item>> {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (view() != null) {
                view().showError(e.getCause().getMessage());
            }
        }

        @Override
        public void onNext(List<Item> items) {
            if (view() != null) {
                view().hideSwipeRefreshLoading();
                view().setCurrentJsonFileNo(mFileNo);
                if (items != null && items.size() > 0) {
                    view().showItems(items);
                } else {
                    view().showError("Unable to fetch!");
                }
            }
        }
    }
}
