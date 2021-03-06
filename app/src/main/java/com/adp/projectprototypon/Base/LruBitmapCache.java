package com.adp.projectprototypon.Base;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by asharshoaib on 2016-09-19.
 */
public class LruBitmapCache  extends LruCache<String, Bitmap> implements ImageLoader.ImageCache
{
    private LruBitmapCache(final int maxSize)
    {
        super(maxSize);
    }

    public LruBitmapCache(@NonNull final Context ctx)
    {
        this(getCacheSize(ctx));
    }

    @Override
    protected int sizeOf(String key, Bitmap value)
    {
        return value.getRowBytes() * value.getHeight();
    }

    @Override
    public Bitmap getBitmap(String url)
    {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap)
    {
        put(url, bitmap);
    }

    private static int getCacheSize(@NonNull final Context context)
    {
        final DisplayMetrics displayMetrics = context.getResources().
                getDisplayMetrics();
        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;
        // 4 bytes per pixel
        final int screenBytes = screenWidth * screenHeight * 4;

        return screenBytes * 3;
    }
}
