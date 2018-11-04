package com.demo.android.ryu.demo.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.List;

/**
 * @author liuweishan on 2018/10/15.
 */

public abstract class DemoBinderManagerImpl extends Binder implements DemoBinderManager {
    public DemoBinderManagerImpl() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static DemoBinderManager asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IInterface iInterface = obj.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && iInterface instanceof DemoBinderManager) {
            return (DemoBinderManager) iInterface;
        }
        return new Proxy(obj);
    }

    @Override
    public abstract List<DemoModel> getDemoModelList() throws RemoteException;

    @Override
    public abstract DemoModel getRandomDemoModel() throws RemoteException;

    @Override
    public abstract void addDemoModel(DemoModel demoModel) throws RemoteException;

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected final boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case IBinder.INTERFACE_TRANSACTION:
                reply.writeString(DESCRIPTOR);
                return true;
            case TRANSACTION_GET_MODEL_LIST: {
                data.enforceInterface(DESCRIPTOR);
                List<DemoModel> _result = this.getDemoModelList();
                reply.writeNoException();
                reply.writeTypedList(_result);
                return true;
            }
            case TRANSACTION_GET_RANDOM_MODEL: {
                data.enforceInterface(DESCRIPTOR);
                DemoModel _result;
                if (getDemoModelList() != null && !getDemoModelList().isEmpty()) {
                    _result = getDemoModelList().get(0);
                } else {
                    _result = null;
                }
                reply.writeNoException();
                reply.writeParcelable(_result, 0);
                return true;
            }
            case TRANSACTION_ADD_MODEL: {
                data.enforceInterface(DESCRIPTOR);
                DemoModel _arg0;
                if (0 != data.readInt()) {
                    _arg0 = DemoModel.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                this.addDemoModel(_arg0);
                reply.writeNoException();
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }

    private static class Proxy implements DemoBinderManager {
        private IBinder mRemote;

        Proxy(IBinder remote) {
            this.mRemote = remote;
        }

        @Override
        public List<DemoModel> getDemoModelList() throws RemoteException {
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();
            List<DemoModel> _result;
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_GET_MODEL_LIST, _data, _reply, 0);
                _reply.readException();
                _result = _reply.createTypedArrayList(DemoModel.CREATOR);
            } finally {
                _data.recycle();
                _reply.recycle();
            }
            return _result;
        }

        @Override
        public DemoModel getRandomDemoModel() throws RemoteException {
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();
            DemoModel _result;
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_GET_RANDOM_MODEL, _data, _reply, 0);
                _reply.readException();
                _result = DemoModel.CREATOR.createFromParcel(_reply);
            } finally {
                _data.recycle();
                _reply.recycle();
            }
            return _result;
        }

        @Override
        public void addDemoModel(DemoModel demoModel) throws RemoteException {
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                if (demoModel != null) {
                    _data.writeInt(1);
                    demoModel.writeToParcel(_data, 0);
                } else {
                    _data.writeInt(0);
                }
                mRemote.transact(TRANSACTION_ADD_MODEL, _data, _reply, 0);
                _reply.readException();
            } finally {
                _data.recycle();
                _reply.recycle();
            }
        }

        @Override
        public IBinder asBinder() {
            return mRemote;
        }

        public String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }
    }
}
