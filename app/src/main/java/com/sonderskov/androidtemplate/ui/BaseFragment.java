package com.sonderskov.androidtemplate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.google.inject.Inject;

import roboguice.fragment.RoboFragment;

public abstract class BaseFragment<T> extends RoboFragment implements DialogHelper {

    @Inject
    private Resources mResources;

    protected abstract T getViewImplementation();
    protected abstract BasePresenter getPresenter();

    @Override
    public void showErrorDialog(Object error) {
        final DialogHelper dialogHelper = (DialogHelper)getActivity();
        if(dialogHelper != null) {
            dialogHelper.showErrorDialog(error);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((BaseActivity) getActivity()).addToBackStack(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onCreate(getArguments());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Attach the view, when the view is ready.
        getPresenter().onViewCreated(getViewImplementation());
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((BaseActivity)getActivity()).removeFromBackStack(this);
    }
}
