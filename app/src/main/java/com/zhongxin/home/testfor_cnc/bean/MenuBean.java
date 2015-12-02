package com.zhongxin.home.testfor_cnc.bean;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Walter on 2015/8/27.
 */
public class MenuBean {
    public String name;
    public Bundle bundle;
    public Class<? extends Fragment> fragment;

    public MenuBean(String name, Bundle bundle,
                    Class<? extends Fragment> fragment)
    {
        this.name = name;
        this.bundle = bundle;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Class<? extends Fragment> getFragment() {
        return fragment;
    }

    public void setFragment(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }
}
