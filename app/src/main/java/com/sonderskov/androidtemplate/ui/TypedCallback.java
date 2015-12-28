package com.sonderskov.androidtemplate.ui;

public interface TypedCallback<T> {

    void onSuccess(T result);
    void onError(Object error);
}
