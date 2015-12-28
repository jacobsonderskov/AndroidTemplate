package com.sonderskov.androidtemplate.service;

import com.sonderskov.androidtemplate.ui.TypedCallback;

public interface ApiService {

    void getString(TypedCallback<String> typedCallback);
}
