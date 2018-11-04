package com.demo.android.ryu.core;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author liuweishan on 2018/10/18.
 */

public abstract class RyuBaseFragment extends Fragment {
    protected View contentView;
    protected boolean inflated;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(getLayoutResId(), container, false);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (contentView != null) {
            onInflated(contentView, savedInstanceState);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract void onInflated(View contentView, Bundle savedInstanceState);

    public View getContentView() {
        return contentView;
    }

}
