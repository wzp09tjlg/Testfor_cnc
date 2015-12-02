package com.zhongxin.home.testfor_cnc.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.zhongxin.home.testfor_cnc.utils.LogUtil;

/**
 * Created by Walter on 2015/7/27.
 */
public class MyService extends Service {
    //服务有三个方法
    private final String TAG = "MyService";

    public MyService(){
        LogUtil.LogE(TAG,"MyService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.LogE(TAG,"onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.LogE(TAG,"onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) { 
        super.onStart(intent, startId);
        LogUtil.LogE(TAG,"onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.LogE(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.LogE(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        LogUtil.LogE(TAG,"onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.LogE(TAG,"onDestroy");
    }
}
