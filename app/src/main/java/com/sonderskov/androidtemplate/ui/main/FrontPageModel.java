package com.sonderskov.androidtemplate.ui.main;

import android.content.res.Resources;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.R;


public class FrontPageModel {

    @Inject
    private Resources mResources;

    private String mText;

    public void init(String text) {
        mText = text;
    }

    // Purely as a proof of concept.
    public String getText() {
        return String.format(mResources.getString(R.string.hello), mText);
    }
}
