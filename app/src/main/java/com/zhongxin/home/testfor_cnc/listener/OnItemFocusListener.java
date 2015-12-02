package com.zhongxin.home.testfor_cnc.listener;

import android.view.View;

/**
 * Created by Walter on 2015/8/27.
 */
public interface OnItemFocusListener<T> {
    void onItemFocusLister(View view, int position, T t, boolean hasFocus);
}
