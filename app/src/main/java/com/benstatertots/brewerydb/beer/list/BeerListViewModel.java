package com.benstatertots.brewerydb.beer.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.benstatertots.brewerydb.api.IWebService;
import com.benstatertots.brewerydb.beer.list.model.BeerItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BeerListViewModel extends ViewModel {

    private LiveData<List<BeerItem>> mBeerList;
    public LiveData<List<BeerItem>> getBeerList() {
        return mBeerList;
    }

    private IWebService mWebService;

    @Inject
    public BeerListViewModel(IWebService webService) {
        mWebService = webService;

        MutableLiveData<List<BeerItem>> mutableBeers = new MutableLiveData<>();
        mutableBeers.setValue(mWebService.getBeers());
        mBeerList = mutableBeers;
    }
}
