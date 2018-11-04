package com.demo.android.ryu.demo.binder;

import android.os.IBinder;

/**
 * @author liuweishan on 2018/10/15.
 */

public class DemoDeathRecipient implements IBinder.DeathRecipient {
    @Override
    public void binderDied() {

    }
}
