package com.sonderskov.androidtemplate.ui.main;

import android.os.Bundle;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.service.TypedCallback;
import com.sonderskov.androidtemplate.ui.BasePresenter;

public class FrontPagePresenter extends BasePresenter<FrontPagePresenter.View, MainNavigation> {

    public static final String ARG_TEXT = "text";

    public interface View extends BasePresenter.View {
        void setText(String text);
        void setApiText(String apiText);
    }

    @Inject
    private FrontPageModel mModel;

    @Override
    public void onCreate(Bundle args) {
        if (args!= null) {
            String text = args.getString(ARG_TEXT);
            mModel.init(text);
        }
    }

    @Override
    public void onStart() {
        // Perform any loading.
        getView().setText(mModel.getText());
        mModel.getApiText(new TypedCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (getView() == null)
                    return; // On async calls we can't be sure that there is a View.
                getView().setApiText(result);
            }

            @Override
            public void onError(Object error) {
                if (getView() == null) return;
                getView().getDialogHelper().showErrorDialog(error);
            }
        });
    }

    public void onNavigationButtonClick() {
        getNavigation().showPlaceHolder("Navigation Button clicked!");
    }
}
