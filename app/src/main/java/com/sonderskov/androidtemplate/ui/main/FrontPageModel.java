package com.sonderskov.androidtemplate.ui.main;

import android.content.res.Resources;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.R;
import com.sonderskov.androidtemplate.service.ApiService;
import com.sonderskov.androidtemplate.service.TypedCallback;


public class FrontPageModel {

    @Inject
    private Resources mResources;
    @Inject
    private ApiService mService;

    private String mText;

    public void init(String text) {
        mText = text;
    }

    // Purely as a proof of concept.
    public String getText() {
        return String.format(mResources.getString(R.string.hello), mText);
    }

    public void getApiText(final TypedCallback<String> callback) {
        mService.getString(new TypedCallback<String>() {

            @Override
            public void onSuccess(String result) {
                // TODO: Add whatever logic you want.
                callback.onSuccess(result);
            }

            @Override
            public void onError(Object error) {
                callback.onError(error);
            }
        });
    }
}
