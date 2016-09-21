package com.adp.projectprototypon.Base;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by asharshoaib on 2016-09-19.
 */
public class App extends Application
{
    private static App sInstance;
    private RequestQueue mRequestQueue;
    private LruBitmapCache mLruBitmapCache;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
    }

    public static App getInstance()
    {
        return sInstance;
    }

    @NonNull
    public RequestQueue getVolleyRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(this, new OkHttpStack(new OkHttpClient()));
        }

        return mRequestQueue;
    }

    private static void addRequest(@NonNull final Request<?> request)
    {
        getInstance().getVolleyRequestQueue().add(request);
    }

    public static void addRequest(@NonNull final Request<?> request, @NonNull final String tag)
    {
        request.setTag(tag);
        addRequest(request);
    }

    public static void cancelAllRequests(@NonNull final String tag)
    {
        getInstance().getVolleyRequestQueue().cancelAll(tag);
    }

    @NonNull
    public ImageLoader getVolleyImageLoader()
    {
        if (mImageLoader == null)
        {
            mImageLoader = new ImageLoader
                    (
                            getVolleyRequestQueue(),
                            App.getInstance().getVolleyImageCache()
                    );
        }

        return mImageLoader;
    }

    @NonNull
    private LruBitmapCache getVolleyImageCache()
    {
        if (mLruBitmapCache == null)
        {
            mLruBitmapCache = new LruBitmapCache(sInstance);
        }

        return mLruBitmapCache;
    }

    public static void LogSystem(@NonNull final String tag, @NonNull final String msg){
        Log.i(tag, msg);
    }

}
