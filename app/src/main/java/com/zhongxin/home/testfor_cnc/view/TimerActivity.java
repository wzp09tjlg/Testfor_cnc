package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/8/28.
 */
public class TimerActivity extends Activity implements View.OnClickListener
{
    private final String TAG = "TimerActivity";
    private final int APK = 0X001;
    private final int PICTURE = 0X002;
    private final int MUSIC = 0X003;
    private final int VIDEO = 0X004;
    private Button mBtnStart;
    private Button mBtnStop;
    private boolean scan = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case APK:
                    if(scan){
                        handler.sendEmptyMessageAtTime(APK,5000);
                        Log.e(TAG,""+System.currentTimeMillis());
                    }
                    break;
                case PICTURE:
                    break;
                case MUSIC:
                    break;
                case VIDEO:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_start:
                handler.sendEmptyMessageAtTime(APK,5000);
                break;
            case R.id.cnc_btn_stop:
                scan = false;
                break;
        }
    }

    private void findView(){
        mBtnStart = (Button) findViewById(R.id.cnc_btn_start);
        mBtnStop = (Button) findViewById(R.id.cnc_btn_stop);
    }

    private void initView(){
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }
}
