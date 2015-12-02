package com.zhongxin.home.testfor_cnc.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/28.
 */
public class EventBusActivity extends FragmentActivity implements
        View.OnClickListener
{
    private final String TAG = "EventBusActivity";
    //widget
    private Button mButtonEventBus;
    //data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    private void findView(){
    }

    private void initView(){
    }
}
