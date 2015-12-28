package com.sonderskov.androidtemplate.ui;

import android.os.Bundle;

public abstract class BasePresenter {
    public abstract void onCreate(Bundle args);
    public abstract void onStart();
    public abstract void onDestroy();
}
