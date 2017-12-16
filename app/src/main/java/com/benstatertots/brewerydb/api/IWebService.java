package com.benstatertots.brewerydb.api;

import com.benstatertots.brewerydb.beer.list.model.BeerItem;

import java.util.List;

/**
 * Created by bsnider on 11/18/17.
 */

public interface IWebService {
    List<BeerItem> getBeers();
    BeerItem getBeer(String id);
}
