package com.leo.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Leo on 2016/5/18.
 */
public class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public BaseAdapter() {

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
