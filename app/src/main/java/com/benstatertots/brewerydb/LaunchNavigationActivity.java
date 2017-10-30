package com.benstatertots.brewerydb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.benstatertots.brewerydb.beer.list.BeerListFragment;
import com.benstatertots.brewerydb.beer.list.model.BeerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchNavigationActivity extends AppCompatActivity
        implements BeerListFragment.OnBeerListFragmentInteractionListener {

//    @BindView(R.id.tabs_content_container) ViewGroup mTabsContainer;
    @BindView(R.id.navigation) protected BottomNavigationView mBottomNav;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            final FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.hide(fragmentManager.findFragmentById(R.id.beerlist));
            transaction.hide(fragmentManager.findFragmentById(R.id.brewerylist));

            switch (item.getItemId()) {
                case R.id.navigation_beers:
                    transaction.show(fragmentManager.findFragmentById(R.id.beerlist));
                    break;
                case R.id.navigation_breweries:
                    transaction.show(fragmentManager.findFragmentById(R.id.brewerylist));
                    break;
            }

            transaction.commit();

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

    @Override
    public void onBeerItemTap(BeerItem item) {
        Log.d("brewdb", "item tapped: "+item.id);
    }
}
