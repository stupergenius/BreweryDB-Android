package com.benstatertots.brewerydb.beer.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
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

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link BeerItem} and makes a call to the
 * specified {@link BeerListFragment.OnBeerListFragmentInteractionListener}.
 */
public class MyBeerListRecyclerViewAdapter extends RecyclerView.Adapter<MyBeerListRecyclerViewAdapter.ViewHolder> {

    private final LiveData<List<BeerItem>> mValues;
    private final BeerListFragment.OnBeerListFragmentInteractionListener mListener;
    private final Context mContext;
    private final Drawable mPlaceholder;

    public MyBeerListRecyclerViewAdapter(LiveData<List<BeerItem>> items, BeerListFragment.OnBeerListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext = context;
        mPlaceholder = AppCompatResources.getDrawable(mContext, R.drawable.ic_beers_black_100dp);

        mValues.observe(null, new Observer<List<BeerItem>>() {
            @Override
            public void onChanged(@Nullable List<BeerItem> beerItems) {
                MyBeerListRecyclerViewAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_beerlist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        BeerItem item = mValues.getValue().get(position);
        holder.mItem = item;
        holder.mTitleTextView.setText(item.title);
        holder.mSubtitleTextView.setText(item.description);

        if (item.imageUrl == null || item.imageUrl.isEmpty()) {
            holder.mImageView.setImageDrawable(mPlaceholder);
        } else {
            Picasso.with(mContext)
                    .load(item.imageUrl)
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
        return mValues.getValue().size();
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
