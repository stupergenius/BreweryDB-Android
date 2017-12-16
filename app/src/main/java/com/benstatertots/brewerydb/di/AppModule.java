package com.benstatertots.brewerydb.di;

import android.app.Application;

import com.benstatertots.brewerydb.api.IWebService;
import com.benstatertots.brewerydb.api.WebService;
import com.benstatertots.brewerydb.beer.list.MyBeerListRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

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

    @Provides
    Picasso providePicasso(Application app) {
        return Picasso.with(app);
    }

    //@ActivityScope
    @Provides
    MyBeerListRecyclerViewAdapter provideBeerListAdapter(Application app, Picasso picasso) {
        return new MyBeerListRecyclerViewAdapter(app, picasso);
    }
}
