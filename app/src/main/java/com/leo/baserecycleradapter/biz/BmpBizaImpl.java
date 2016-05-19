package com.leo.baserecycleradapter.biz;

import com.leo.baserecycleradapter.R;
import com.leo.baserecycleradapter.bean.BitmapWithDes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2016/5/18.
 */
public class BmpBizaImpl implements IBmpBiz<BitmapWithDes> {
    @Override
    public List<BitmapWithDes> requestData() {
        List<BitmapWithDes> arrays = new ArrayList<>();
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        arrays.add(new BitmapWithDes(R.drawable.test_filter_pic, "1"));
        return arrays;
    }
}
