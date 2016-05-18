package com.leo.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Leo on 2016/5/18.
 */
public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> implements IHeaderAndFooter {
    Context mContext;
    LayoutInflater mInflater;
    List<T> mDatas;
    int mLayoutId;
    View mHeader;
    View mFooter;

    protected static final int TYPE_HEADER = -0x100;
    protected static final int TYPE_FOOTER = -0x101;
    protected static final int TYPE_DEFAULT = -0x102;

    public BaseAdapter(Context context, List<T> data, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = data;
        mLayoutId = layoutId;
    }

    protected Context getContext() {
        return mContext;
    }

    protected List<T> getDatas() {
        return mDatas;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return TYPE_HEADER;
        } else if (isFooterView(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_DEFAULT;
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreate(parent, viewType);
    }

    public abstract VH onCreate(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        int viewType = getItemViewType(position);
        if (hasHeaderView())
            position--;
        if (viewType != TYPE_HEADER && viewType != TYPE_FOOTER) {
            onBind(viewType, holder, position, mDatas.get(position));
        }
    }

    protected abstract void onBind(int viewType, VH holder, int position, T t);


    public boolean hasHeaderView() {
        return mHeader != null ? true : false;
    }

    public boolean hasFooterView() {
        return mFooter != null ? true : false;
    }

    @Override
    public int getItemCount() {
        return mDatas.size() + (hasFooterView() ? 1 : 0) + (hasHeaderView() ? 1 : 0);
    }

    @Override
    public View getFooterView() {
        return mFooter;
    }

    @Override
    public View getHeaderView() {
        return mHeader;
    }

    @Override
    public void addHeaderView(View header) {
        if (hasHeaderView())
            throw new IllegalStateException("You have already added a header view.");
        mHeader = header;
        notifyItemInserted(0);
    }

    @Override
    public void addFooterView(View footer) {
        if (hasFooterView())
            throw new IllegalStateException("You have already added a footer view.");
        mFooter = footer;
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public boolean removeHeaderView() {
        if (hasHeaderView()) {
            notifyItemRemoved(0);
            mHeader = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFooterView() {
        if (hasFooterView()) {
            notifyItemRemoved(getItemCount() - 1);
            mFooter = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFooterView(int position) {
        return (position == mDatas.size() - 1) && hasFooterView();
    }

    @Override
    public boolean isHeaderView(int position) {
        return (position == 0) && hasHeaderView();
    }

    public void add(T item) {
        mDatas.add(item);
        int index = mDatas.size() - 1;
        if (hasHeaderView())
            index++;
        notifyItemInserted(index);
    }

    public void insert(int index, T item) {
        mDatas.add(index, item);
        if (hasHeaderView())
            index++;
        notifyItemInserted(index);
    }

    public void addAll(List<T> items) {
        if (items == null || items.size() == 0) {
            return;
        }
        int start = mDatas.size();
        mDatas.addAll(items);
        if (hasHeaderView())
            start++;
        notifyItemRangeInserted(start, items.size());
    }

    public void remove(T item) {
        if (mDatas.contains(item)) {
            int index = mDatas.indexOf(item);
            remove(index);
        }
    }

    public void remove(int index) {
        mDatas.remove(index);
        if (hasHeaderView())
            index++;
        notifyItemRemoved(index);
    }

    public void set(T oldItem, T newItem) {
        set(mDatas.indexOf(oldItem), newItem);
    }

    public void set(int index, T item) {
        mDatas.set(index, item);
        if (hasHeaderView())
            index++;
        notifyItemChanged(index);
    }

    public void replaceAll(List<T> items) {
        mDatas.clear();
        mDatas.addAll(items);
        int start = 0;
        if (hasHeaderView())
            start++;
        notifyItemRangeInserted(start, items.size());
    }

    public boolean contains(T item) {
        return mDatas.contains(item);
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }
}
