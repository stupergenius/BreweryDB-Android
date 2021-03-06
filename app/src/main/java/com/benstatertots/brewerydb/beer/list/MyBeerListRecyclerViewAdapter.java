package com.benstatertots.brewerydb.beer.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.benstatertots.brewerydb.R;
import com.benstatertots.brewerydb.beer.list.model.BeerItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link BeerItem} and makes a call to the
 * specified {@link BeerListFragment.OnBeerListFragmentInteractionListener}.
 */
public class MyBeerListRecyclerViewAdapter extends RecyclerView.Adapter<MyBeerListRecyclerViewAdapter.ViewHolder> {

    private List<BeerItem> mBeers;
    private BeerListFragment.OnBeerListFragmentInteractionListener mListener;
    private final Context mContext;
    private final Drawable mPlaceholder;
    private final Picasso mPicasso;

    public MyBeerListRecyclerViewAdapter(Context context, Picasso picasso) {
        mBeers = new ArrayList<>();
        mContext = context;
        mPlaceholder = AppCompatResources.getDrawable(mContext, R.drawable.ic_beers_black_100dp);
        mPicasso = picasso;
    }

    public void setBeers(List<BeerItem> items) {
        mBeers = items;
        this.notifyDataSetChanged();
        //TODO: use diffutil to only notify about the changed items, e.g:
        // https://stackoverflow.com/questions/44489235/update-recyclerview-with-android-livedata
    }

    public void setmListener(BeerListFragment.OnBeerListFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_beerlist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        BeerItem item = mBeers.get(position);
        holder.mItem = item;
        holder.mTitleTextView.setText(item.name);
        holder.mSubtitleTextView.setText("Description " + item.id);

        if (item.labels.large == null || item.labels.large.isEmpty()) {
            holder.mImageView.setImageDrawable(mPlaceholder);
        } else {
            Picasso.with(mContext)
                    .load(item.labels.large)
                    .placeholder(mPlaceholder)
                    .into(holder.mImageView);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onBeerItemTap(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mTitleTextView;
        public final TextView mSubtitleTextView;
        public BeerItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = view.findViewById(R.id.image);
            mTitleTextView = view.findViewById(R.id.title);
            mSubtitleTextView = view.findViewById(R.id.subtitle);
        }
    }
}
