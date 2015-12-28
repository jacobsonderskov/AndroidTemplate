package com.sonderskov.androidtemplate.ui.main;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.ui.BasePresenter;

public class FrontPagePresenter extends BasePresenter {

    public interface View {
        void setText(String text);
    }

    private MainNavigation mNavigation;
    private View mView;

    @Inject
    private FrontPageModel mModel;

    public void setNavigation(final MainNavigation navigation) {
        mNavigation = navigation;
    }

    public void setView(View view) {
        mView = view;
    }

    public void init(String text) {
        mModel.init(text);
    }

    @Override
    public void onStart() {
        // Perform any loading.
        mView.setText(mModel.getText());
    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
