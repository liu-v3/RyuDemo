package com.demo.android.ryu.demo.binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author liuweishan on 2018/10/15.
 */

public class DemoModel implements Parcelable {
    private long modelId;
    private String modelDesc;

    protected DemoModel(Parcel in) {
        modelId = in.readLong();
        modelDesc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(modelId);
        dest.writeString(modelDesc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DemoModel> CREATOR = new Creator<DemoModel>() {
        @Override
        public DemoModel createFromParcel(Parcel in) {
            return new DemoModel(in);
        }

        @Override
        public DemoModel[] newArray(int size) {
            return new DemoModel[size];
        }
    };
}
