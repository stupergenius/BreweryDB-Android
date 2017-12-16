package com.benstatertots.brewerydb.di;

import android.app.Application;

import com.benstatertots.brewerydb.app.BreweryDBApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by bsnider on 11/21/17.
 */

@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    LaunchNavigationActivityModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
    void inject(BreweryDBApplication breweryDBApp);
}
