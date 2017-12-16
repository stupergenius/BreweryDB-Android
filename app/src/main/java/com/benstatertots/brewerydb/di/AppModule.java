package com.benstatertots.brewerydb.di;

import android.app.Application;
import android.content.Context;

import com.benstatertots.brewerydb.api.IWebService;
import com.benstatertots.brewerydb.api.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bsnider on 11/18/17.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {
    @Singleton @Provides
    IWebService provideWebService() {
        return new WebService();
    }
}
