package com.demo.android.ryu.image_utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.android.ryu.utils.SystemUtils;

/**
 * @author liuweishan on 2018/9/28.
 */

public class ImageUtils {
    private static final LruCache<String, Bitmap> mMemoryCache = new LruCache<String, Bitmap>((int) SystemUtils.getEnableMemory()) {
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes() * value.getHeight() / 1024;
        }
    };

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
