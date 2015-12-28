package com.sonderskov.androidtemplate.service.implementation;

import android.os.Vibrator;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.service.DeviceService;

public class DefaultDeviceService implements DeviceService {
    @Inject
    private Vibrator mVibrator;

    @Override
    public void vibrate(long duration) {
        mVibrator.vibrate(duration);
    }
}
