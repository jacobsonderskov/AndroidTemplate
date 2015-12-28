package com.sonderskov.androidtemplate.service.implementation;

import com.sonderskov.androidtemplate.service.ApiService;
import com.sonderskov.androidtemplate.service.TypedCallback;

public class DefaultApiService implements ApiService {

    @Override
    public void getString(final TypedCallback<String> callback) {
        // TODO: Access async backend.
        callback.onSuccess("From DefaultApiService");
    }
}
