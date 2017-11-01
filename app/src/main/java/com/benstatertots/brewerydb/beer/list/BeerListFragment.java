package com.benstatertots.brewerydb.beer.list;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.benstatertots.brewerydb.R;
import com.benstatertots.brewerydb.beer.list.model.BeerItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnBeerListFragmentInteractionListener}
 * interface.
 */
public class BeerListFragment extends Fragment {

//    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnBeerListFragmentInteractionListener mListener;

    private RecyclerView mView;
    private BeerListViewModel mViewModel;

    public BeerListFragment() {
    }

    @SuppressWarnings("unused")
    public static BeerListFragment newInstance() {
        BeerListFragment fragment = new BeerListFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BeerListViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beerlist, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            mView = (RecyclerView) view;
            Context context = mView.getContext();
            //TODO: inject picasso?
            mView.setAdapter(new MyBeerListRecyclerViewAdapter(mViewModel.getBeerList(), mListener, context));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBeerListFragmentInteractionListener) {
            mListener = (OnBeerListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnBeerListFragmentInteractionListener {
        void onBeerItemTap(BeerItem item);
    }
}
