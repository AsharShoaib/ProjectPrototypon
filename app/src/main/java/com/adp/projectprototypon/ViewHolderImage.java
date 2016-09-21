package com.adp.projectprototypon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adp.projectprototypon.Base.App;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by asharshoaib on 2016-09-20.
 */
public class ViewHolderImage extends RecyclerView.ViewHolder {
    private NetworkImageView mNetworkImageView;

    public ViewHolderImage(@NonNull final View itemView)
    {
        super(itemView);
        bindResources(itemView);
    }

    private void bindResources(final @NonNull View itemView)
    {
        mNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.networkImageView);
        mNetworkImageView.setDefaultImageResId(R.drawable.image_sun_smile);
        mNetworkImageView.setErrorImageResId(R.drawable.image_cloud_sad);
    }

    public void onBind(@NonNull final String imageUrl)
    {
        mNetworkImageView.setImageUrl(imageUrl, App.getInstance().getVolleyImageLoader());
    }
}
