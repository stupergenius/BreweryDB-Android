package com.benstatertots.brewerydb.api;

import com.benstatertots.brewerydb.beer.list.model.BeerItem;
import com.benstatertots.brewerydb.beer.list.model.Labels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsnider on 11/18/17.
 */

public final class WebService implements IWebService {

    @Override
    public List<BeerItem> getBeers() {
        List<BeerItem> beers = new ArrayList<>();
        for (int i=0; i<25; i++) {
            BeerItem beer = new BeerItem();
            beer.id = String.valueOf(i);
            beer.name = "Beer " + i;
            beer.labels = new Labels();
            beer.labels.icon = beer.labels.large = beer.labels.medium = "http://i.imgur.com/DvpvklR.png";

            beers.add(beer);
        }
        return beers;
    }

    @Override
    public BeerItem getBeer(String id) {
        BeerItem beer = new BeerItem();
        beer.id = String.valueOf(id);
        beer.name = "Beer " + id;
        beer.labels = new Labels();
        beer.labels.icon = beer.labels.large = beer.labels.medium = "http://i.imgur.com/DvpvklR.png";

        return beer;
    }
}
