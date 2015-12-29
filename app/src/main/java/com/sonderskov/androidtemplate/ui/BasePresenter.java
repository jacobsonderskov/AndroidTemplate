package com.sonderskov.androidtemplate.ui;

import android.os.Bundle;

public abstract class BasePresenter<View, Navigation> {



    public interface View {
        DialogHelper getDialogHelper();
    }

    private View mView;
    private Navigation mNavigation;

    protected View getView() {
        return mView;
    }

    protected Navigation getNavigation() {
        return mNavigation;
    }

    public abstract void onCreate(Bundle args);

    public void onViewCreated(final View view) {
        mView = view;
    }

    public void onActivityCreated(final Navigation navigation) {
        mNavigation = navigation;
    }

    public abstract void onStart();

    public void onDestroy() {
        mView = null;
        mNavigation = null;
    }
}
