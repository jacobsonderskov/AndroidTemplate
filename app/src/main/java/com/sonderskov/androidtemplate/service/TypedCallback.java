package com.sonderskov.androidtemplate.service;

public interface TypedCallback<T> {

    void onSuccess(T result);
    void onError(Object error);
}
