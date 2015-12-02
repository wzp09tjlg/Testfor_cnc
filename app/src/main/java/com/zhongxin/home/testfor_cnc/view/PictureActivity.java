package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Walter on 2015/8/31.
 */
public class PictureActivity extends Activity  implements
        View.OnClickListener
{
    private final String TAG = "PictureActivity";
    private Button mButtonStop;
    private int count;
    private boolean isStop =false;
    private int what = 0x123;
    private Timer timer;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if( !isStop && msg.what==what){
                Log.e(TAG,"check data....:"+count);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_query);
        count = getIntent().getExtras().getInt("PIC_COUNT",0);
        findView();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        timer.schedule(new MyTask(),5000,5000);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cnc_btn_stop){
            timer.purge();
            isStop = true;
            timer.cancel();

        }
    }

    private void findView(){
        mButtonStop = (Button) this.findViewById(R.id.cnc_btn_stop);
        timer = new Timer();
    }

    private void initView(){
        mButtonStop.setOnClickListener(this);
    }

   class MyTask extends TimerTask{
       @Override
       public void run() {
           count += 10;
         handler.sendEmptyMessageDelayed(what,1000);
       }
   }
}
