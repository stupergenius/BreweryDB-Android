package com.benstatertots.brewerydb.di;

import com.benstatertots.brewerydb.beer.list.BeerListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract BeerListFragment contributeBeerListFragment();
}
