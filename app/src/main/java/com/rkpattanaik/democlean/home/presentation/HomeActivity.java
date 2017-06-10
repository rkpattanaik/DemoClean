package com.rkpattanaik.democlean.home.presentation;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.rkpattanaik.democlean.MainApp;
import com.rkpattanaik.democlean.R;
import com.rkpattanaik.democlean.common.base.BaseActivity;
import com.rkpattanaik.democlean.data.model.Item;
import com.rkpattanaik.democlean.home.di.HomeActivityModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;
    @BindView(R.id.layoutRefresh)
    SwipeRefreshLayout layoutRefresh;

    private int mCurrentJsonFileNo = 1; // This is the items from the json file which is currently displayed

    @Inject
    ItemsAdapter mItemsAdapter;
    @Inject
    HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        // Set up Toolbar
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        // Set up RecyclerView
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(mItemsAdapter);

        // Set up HomePresenter
        mPresenter.attachView(this);

        // Set up SwipeRefreshLayout to listen to swipe to refresh event
        layoutRefresh.setOnRefreshListener(() -> mPresenter.onRefreshed());
    }

    @Override
    protected void setupActivityComponent() {
        MainApp.getInstance()
                .getAppComponent()
                .plus(new HomeActivityModule(this))
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void hideSwipeRefreshLoading() {
        layoutRefresh.setRefreshing(false);
    }

    @Override
    public void showItems(List<Item> items) {
        mItemsAdapter.setItems(items);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCurrentJsonFileNo(int fileNo) {
        mCurrentJsonFileNo = fileNo;
    }

    @Override
    public int getCurrentJsonFileNo() {
        return mCurrentJsonFileNo;
    }
}
