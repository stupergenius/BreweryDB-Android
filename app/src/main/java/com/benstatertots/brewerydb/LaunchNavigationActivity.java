package com.benstatertots.brewerydb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.benstatertots.brewerydb.beer.list.BeerListFragment;
import com.benstatertots.brewerydb.brewery.list.BreweryListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchNavigationActivity extends AppCompatActivity {

//    @BindView(R.id.tabs_content_container) ViewGroup mTabsContainer;
    @BindView(R.id.navigation) BottomNavigationView mBottomNav;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment tabFrag = null;
            switch (item.getItemId()) {
                case R.id.navigation_beers:
                    tabFrag = fragmentManager.findFragmentById(R.id.beerlist_list);
                    if (tabFrag == null) {
                        tabFrag = new BeerListFragment();
                    }
                    break;
                case R.id.navigation_breweries:
                    tabFrag = fragmentManager.findFragmentById(R.id.brewerylist_list);
                    if (tabFrag == null) {
                        tabFrag = new BreweryListFragment();
                    }
                    break;
            }

            if (tabFrag == null) {
                return false;
            }

            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.tabs_content_container, tabFrag).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_navigation);
        ButterKnife.bind(this);

        mBottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mBottomNav.setSelectedItemId(R.id.navigation_beers);
    }

}
