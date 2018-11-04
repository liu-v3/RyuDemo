package com.demo.android.ryu.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * @author liuweishan on 2018/9/28.
 */

public class MainThreadUtils {
    private static class HandlerHolder {
        private static final Handler handler = new  Handler(Looper.getMainLooper());
    }

    public static void post(@NonNull Runnable runnable) {
        HandlerHolder.handler.post(runnable);
    }

    public static void postDelay(@NonNull Runnable runnable, long delayMillis) {
        HandlerHolder.handler.postDelayed(runnable, delayMillis);
    }

    public static void cancelDelayingMessage(@NonNull Runnable runnable) {
        HandlerHolder.handler.removeCallbacks(runnable);
    }

    public static void runOnMainThread(@NonNull Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            HandlerHolder.handler.post(runnable);
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
