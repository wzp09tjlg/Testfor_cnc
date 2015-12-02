package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/15.
 */
public class SelfViewActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "";
    private Button mButtonSelfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfview);

        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_self_view_location:
                break;
        }
    }

    private void findView(){
        mButtonSelfView = (Button) findViewById(R.id.cnc_btn_self_view_location);
    }

    private void initView(){
        mButtonSelfView.setOnClickListener(this);
    }
}
