package com.sonderskov.androidtemplate.ui;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.ui.main.FrontPagePresenter;
import com.sonderskov.androidtemplate.ui.main.MainNavigation;


public abstract class NullFragment extends BaseFragment<Object, Object> {

    @Inject
    protected NullPresenter mPresenter;

    @Override
    protected FrontPagePresenter.View getConcreteView() {
        return null;
    }

    @Override
    protected MainNavigation getConcreteNavigation() {
        return null;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }
}
