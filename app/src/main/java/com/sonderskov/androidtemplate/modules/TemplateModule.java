package com.sonderskov.androidtemplate.modules;

import com.google.inject.AbstractModule;
import com.sonderskov.androidtemplate.service.ApiService;
import com.sonderskov.androidtemplate.service.DeviceService;
import com.sonderskov.androidtemplate.service.implementation.DefaultApiService;
import com.sonderskov.androidtemplate.service.implementation.DefaultDeviceService;

public class TemplateModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(ApiService.class).to(DefaultApiService.class);
        bind(DeviceService.class).to(DefaultDeviceService.class);


        // Try, try, try to avoid this. Singletons are evil.
        // bind(FrontPageModel.class).asEagerSingleton();
    }
}
