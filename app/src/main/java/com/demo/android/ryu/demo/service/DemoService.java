package com.demo.android.ryu.demo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author liuweishan on 2018/10/12.
 */

public class DemoService extends Service {
    private static final String TAG = "DemoService";

    private DemoServiceBinder mDemoServiceBinder = new DemoServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mDemoServiceBinder;
    }

    // 启动service的方法
    public static void onStartService(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, DemoService.class);
        context.startService(intent);
    }

    // 停止service对方法
    public static void onStopService(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, DemoService.class);
        context.stopService(intent);
    }
}
