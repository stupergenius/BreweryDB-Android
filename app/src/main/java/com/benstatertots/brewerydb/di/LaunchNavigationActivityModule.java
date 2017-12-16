package com.benstatertots.brewerydb.di;

import com.benstatertots.brewerydb.LaunchNavigationActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LaunchNavigationActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract LaunchNavigationActivity contributeLaunchNavigationActivity();
}
