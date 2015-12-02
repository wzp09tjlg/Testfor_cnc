package com.zhongxin.home.testfor_cnc.listener;

import android.view.View;

/**
 * Created by Walter on 2015/8/27.
 */
public interface OnItemClickListener<T> {
    void onItemClickLister(View view, int position, T t);
}
