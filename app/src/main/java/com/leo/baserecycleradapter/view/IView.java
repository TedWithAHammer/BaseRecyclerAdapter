package com.leo.baserecycleradapter.view;

import java.util.List;

/**
 * Created by Leo on 2016/5/18.
 */
public interface IView<T> {
    void bindAdapter(List<T> data);
}
