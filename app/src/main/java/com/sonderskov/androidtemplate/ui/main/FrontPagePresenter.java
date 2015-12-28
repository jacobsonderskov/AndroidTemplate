package com.sonderskov.androidtemplate.ui.main;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.ui.BasePresenter;
import com.sonderskov.androidtemplate.ui.DialogHelper;
import com.sonderskov.androidtemplate.service.TypedCallback;

public class FrontPagePresenter extends BasePresenter {

    public interface View {
        DialogHelper getDialogHelper();
        void setText(String text);
        void setApiText(String apiText);
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

        mModel.getApiText(new TypedCallback<String>() {

            @Override
            public void onSuccess(String result) {
                if(mView == null) return; // On async calls we can't be sure that there is a View.

                mView.setApiText(result);
            }

            @Override
            public void onError(Object error) {
                if(mView == null) return;
                mView.getDialogHelper().showErrorDialog(error);
            }
        });

    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
