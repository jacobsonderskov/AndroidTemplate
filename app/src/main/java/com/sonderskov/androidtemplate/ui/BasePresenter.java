package com.sonderskov.androidtemplate.ui;

import android.os.Bundle;

public abstract class BasePresenter<T> {

    protected T mView;

    public interface View {
        DialogHelper getDialogHelper();
    }

    public abstract void onCreate(Bundle args);

    public void onViewCreated(T view) {
        mView = view;
    }

    public abstract void onStart();

    public void onDestroy() {
        mView = null;
    }
}
