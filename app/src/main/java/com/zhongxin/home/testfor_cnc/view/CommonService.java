package com.zhongxin.home.testfor_cnc.view;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Wu on 2015/10/19.
 */
public class CommonService extends Service {
    private final String TAG = "CommonService";
    private static int NUM = 0;
    //widget
    //data
    private Thread myThread;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    //interface
     @Override
    public void onCreate() {
        super.onCreate();
         Log.e(TAG,"onCreate");
         mediaPlayer = MediaPlayer.create(this, R.raw.yous);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        try{
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception e){

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        myThread = new Thread(new MyRunnable());
        myThread.run();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG,"onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
        mediaPlayer.stop();
    }

    class MyRunnable implements  Runnable{
        @Override
        public void run() {
            try{
//                while(true)
                {
                    Log.e(TAG," NUM:" + NUM);
                    NUM ++;
                    Thread.currentThread().sleep(3 * 1000);
                }
            }catch (Exception e){

            }
        }
    }
}
