package com.leo.baseadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by Leo on 2016/5/18.
 */
public abstract class RecyclerAdapter<T> extends BaseAdapter<T, BaseViewHolder> {
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerAdapter(Context context, List<T> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder;
        if (viewType == TYPE_HEADER) {
            baseViewHolder = new  BaseViewHolder(getHeaderView());
        } else if (viewType == TYPE_FOOTER) {
            baseViewHolder = new BaseViewHolder(getFooterView());
        } else {
            baseViewHolder = new BaseViewHolder(mInflater.inflate(mLayoutId, parent, false));
        }
        return baseViewHolder;
    }

    @Override
    protected void onBind(int viewType, BaseViewHolder holder, final int position, T t) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, getItemViewType(position), position);
                }
            });
        }
    }

}
