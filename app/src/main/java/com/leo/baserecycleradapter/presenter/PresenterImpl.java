package com.leo.baserecycleradapter.presenter;

import com.leo.baserecycleradapter.bean.BitmapWithDes;
import com.leo.baserecycleradapter.biz.BmpBizaImpl;
import com.leo.baserecycleradapter.biz.IBmpBiz;
import com.leo.baserecycleradapter.view.IView;

import java.util.List;

/**
 * Created by Leo on 2016/5/18.
 */
public class PresenterImpl implements IPresenter {
    IView view;
    IBmpBiz<BitmapWithDes> bmps;

    public PresenterImpl(IView view) {
        this.view = view;
        bmps = new BmpBizaImpl();
    }

    @Override
    public void showRecyclerView() {
        List<BitmapWithDes> modules = bmps.requestData();
        view.bindAdapter(modules);
    }
}
