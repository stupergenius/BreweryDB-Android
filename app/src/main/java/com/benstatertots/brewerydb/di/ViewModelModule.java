package com.benstatertots.brewerydb.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.benstatertots.brewerydb.beer.list.BeerListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by bsnider on 12/3/17.
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BeerListViewModel.class)
    abstract ViewModel bindBeerListViewModel(BeerListViewModel beerListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BreweryDBViewModelFactory factory);
}
