package com.demo.android.ryu.demo.binder;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import java.util.List;

/**
 * @author liuweishan on 2018/10/15.
 */

public interface DemoBinderManager extends IInterface {
    String DESCRIPTOR = "ryu.aidl.demo.binder.descriptor.DemoBinderManager";

    int TRANSACTION_GET_MODEL_LIST = IBinder.FIRST_CALL_TRANSACTION + 1;
    int TRANSACTION_GET_RANDOM_MODEL = IBinder.FIRST_CALL_TRANSACTION + 2;
    int TRANSACTION_ADD_MODEL = IBinder.FIRST_CALL_TRANSACTION + 3;

    List<DemoModel> getDemoModelList() throws RemoteException;

    DemoModel getRandomDemoModel() throws RemoteException;

    void addDemoModel(DemoModel demoModel) throws RemoteException;
}
