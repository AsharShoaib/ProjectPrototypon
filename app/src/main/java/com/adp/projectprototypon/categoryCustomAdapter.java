package com.adp.projectprototypon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by asharshoaib on 16-09-18.
 */
public class categoryCustomAdapter extends RecyclerView.Adapter<FeedListRowHolder> {

    private List<FeedItem> feedItemList;

    private Context mContext;

    public categoryCustomAdapter(Context context, List<FeedItem> data) {
        this.feedItemList = data;
        this.mContext = context;

    }

    @Override
    public FeedListRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        FeedListRowHolder viewholder = new FeedListRowHolder((TextView)v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(FeedListRowHolder holder, int position) {
        FeedItem feedItem = feedItemList.get(position);

        Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.title.setText(Html.fromHtml(feedItem.getTitle(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.title.setText(Html.fromHtml(feedItem.getTitle()));
        }

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

}
