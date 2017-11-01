package com.benstatertots.brewerydb.beer.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.benstatertots.brewerydb.beer.list.model.BeerItem;

import java.util.ArrayList;
import java.util.List;

public class BeerListViewModel extends ViewModel {

    private LiveData<List<BeerItem>> mBeerList;
    public LiveData<List<BeerItem>> getBeerList() {
        return mBeerList;
    }

    public BeerListViewModel() {
        List<BeerItem> beers = new ArrayList<>();
        for (int i=0; i<25; i++) {
            beers.add(new BeerItem(String.valueOf(i), "Beer "+i, "Beer Description "+i, "http://i.imgur.com/DvpvklR.png"));
        }
        MutableLiveData<List<BeerItem>> mutableBeers = new MutableLiveData<>();
        mutableBeers.setValue(beers);
        mBeerList = mutableBeers;
    }
}
