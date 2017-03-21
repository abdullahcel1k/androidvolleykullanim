package com.example.abdullah.volleyarrayobject;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by abdullah on 3/20/17.
 */

public class LruBitmapCache extends LruCache<String, Bitmap> implements
        ImageLoader.ImageCache {


    public static int getDefaultCacheSize(){
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory /8;

        return cacheSize;
    }

    public LruBitmapCache(){
        this(getDefaultCacheSize());
    }

    public LruBitmapCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
}
