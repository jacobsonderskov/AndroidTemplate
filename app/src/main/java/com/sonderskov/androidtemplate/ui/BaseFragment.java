package com.sonderskov.androidtemplate.ui;

import android.content.res.Resources;

import com.google.inject.Inject;

import roboguice.fragment.RoboFragment;

public class BaseFragment extends RoboFragment implements DialogHelper {
    @Inject
    private Resources mResources;

    @Override
    public void showErrorDialog(Object error) {
        final DialogHelper dialogHelper = (DialogHelper)getActivity();
        if(dialogHelper != null) {
            dialogHelper.showErrorDialog(error);
        }
    }
}
