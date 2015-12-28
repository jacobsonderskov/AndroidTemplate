package com.sonderskov.androidtemplate.service.implementation;

import com.sonderskov.androidtemplate.service.ApiService;
import com.sonderskov.androidtemplate.ui.TypedCallback;

public class DefaultApiService implements ApiService {

    @Override
    public void getString(final TypedCallback<String> typedCallback) {
        // TODO: Access async backend.
        typedCallback.onSuccess("From DefaultApiService");
    }
}
