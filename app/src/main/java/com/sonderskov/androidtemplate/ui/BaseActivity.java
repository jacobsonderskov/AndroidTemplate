package com.sonderskov.androidtemplate.ui;

import android.content.res.Resources;
import android.widget.Toast;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.R;

import roboguice.activity.RoboActionBarActivity;

public class BaseActivity extends RoboActionBarActivity implements DialogHelper {

    @Inject
    private Resources mResources;

    @Override
    public void showErrorDialog(Object error) {
        // TODO: Implement however you want.
        Toast.makeText(this, mResources.getText(R.string.dialog_error_unknown), Toast.LENGTH_SHORT).show();
    }
}
