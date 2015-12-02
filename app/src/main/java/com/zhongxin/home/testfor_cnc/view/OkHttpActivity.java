package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/10.
 */
public class OkHttpActivity extends Activity {
    private final String TAG = "OkHttpActivity";
    //widget
    private Button mButtonStart;
    private Button mButtonStop;
    private Button mButtonQuery;
    private Button mButtonHistory;
    //data
    //interface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findView();
        initView();
    }

    private void findView(){
        mButtonStart = (Button)findViewById(R.id.cnc_btn_http_start);
        mButtonStop = (Button)findViewById(R.id.cnc_btn_http_stop);
        mButtonQuery = (Button)findViewById(R.id.cnc_btn_http_query);
        mButtonHistory = (Button)findViewById(R.id.cnc_btn_http_history);
    }

    private void initView(){

    }
}
