package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/23.
 * 主要是测试handler发送消息 使用remove 方法查看是否能够将消息取消掉
 */
public class HandlerActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "HandlerActivity";
    private final int   MSG_START = 1001;
    private final int   MSG_STOP  = 1002;
    private final int   MSG_REMOVE = 1003;
    //widget
    private Button mButtonStart;
    private Button mButtonStop;
    private Button mButtonRemove;
    //data
    private int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_START:
                    Log.e(TAG, "COUNT:" + count + "  MSG_START.......");
                    count ++;
                    Message msg1 = Message.obtain();
                    msg1.what = MSG_START;
                    handler.sendMessageDelayed(msg1,2 * 1000);
                break;
                case MSG_STOP:
                    Log.e(TAG, "COUNT:" + count + "  MSG_STOP.......");
                    count ++;
                    handler.sendEmptyMessageDelayed(MSG_STOP,2 * 1000);
                    break;
                case MSG_REMOVE:
                    Log.e(TAG, "COUNT:" + count + "  MSG_REMOVE.......");
                    count ++;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handler);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_handler_start:
                Message msg1 = Message.obtain();
                msg1.what = MSG_START;
                handler.sendMessageDelayed(msg1,2 * 1000);
                break;
            case R.id.cnc_btn_handler_stop:
                handler.sendEmptyMessageDelayed(MSG_STOP,2 * 1000);
                break;
            case R.id.cnc_btn_handler_remove:
//                handler.removeMessages(MSG_START);
//                handler.removeMessages(MSG_STOP);
//                handler.removeAll();
                handler.sendEmptyMessageDelayed(MSG_REMOVE,2 * 1000);
                handler.removeCallbacksAndMessages(null);//这是取消所有消息的动作
                break;
        }
    }

    private void findView(){
      mButtonStart = (Button) this.findViewById(R.id.cnc_btn_handler_start);
      mButtonStop  = (Button) this.findViewById(R.id.cnc_btn_handler_stop);
      mButtonRemove = (Button) this.findViewById(R.id.cnc_btn_handler_remove);
    }

    private void initView(){
     mButtonStart.setOnClickListener(this);
     mButtonStop.setOnClickListener(this);
     mButtonRemove.setOnClickListener(this);
    }

}
