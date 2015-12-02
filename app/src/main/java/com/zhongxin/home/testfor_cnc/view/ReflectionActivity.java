package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/7/27.
 */
public class ReflectionActivity extends Activity {

    private final String TAG = "ReflectionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_reflection);

        findView();
        initView();
    }

    private void findView(){}

    private void initView(){}
}
