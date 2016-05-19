package com.leo.baserecycleradapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leo.baseadapter.BaseViewHolder;
import com.leo.baseadapter.RecyclerAdapter;
import com.leo.baserecycleradapter.bean.BitmapWithDes;
import com.leo.baserecycleradapter.presenter.IPresenter;
import com.leo.baserecycleradapter.presenter.PresenterImpl;
import com.leo.baserecycleradapter.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    RecyclerView recyclerView;

    IPresenter mPresenter;
    private LinearLayoutManager llm;
    private FinalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mPresenter = new PresenterImpl(this);
        mPresenter.showRecyclerView();
    }


    @Override
    public void bindAdapter(List data) {
        llm = new LinearLayoutManager(this);
        adapter = new FinalAdapter(this, data, R.layout.item_test);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    class FinalAdapter extends RecyclerAdapter<BitmapWithDes> {

        public FinalAdapter(Context context, List<BitmapWithDes> data, int layoutId) {
            super(context, data, layoutId);
        }

        @Override
        protected void onBind(int viewType, BaseViewHolder holder, int position, BitmapWithDes bitmapWithDes) {
            super.onBind(viewType, holder, position, bitmapWithDes);
            holder.setBackgroundRes(R.id.iv_top, bitmapWithDes.bmpId);
            holder.setText(R.id.tv_bottom, bitmapWithDes.bmpDes);
        }
    }

}
