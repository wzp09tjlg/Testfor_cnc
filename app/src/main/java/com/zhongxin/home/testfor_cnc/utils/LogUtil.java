package com.zhongxin.home.testfor_cnc.utils;

import android.util.Log;

/**
 * Created by Walter on 2015/7/25.
 */
public class LogUtil {
    private static final Boolean DEBUG =  true;

    public static void LogE(String tag,String msg){
        if(DEBUG)
        Log.e(tag,msg);
    }

    public static void LogD(String tag,String msg){
        if(DEBUG)
        Log.d(tag,msg);
    }

    public static void LogI(String tag,String msg){
        if(DEBUG)
        Log.i(tag,msg);
    }

    public static void LogV(String tag,String msg){
        if(DEBUG)
        Log.v(tag,msg);
    }

    public static void LogW(String tag,String msg){
        if(DEBUG)
        Log.w(tag,msg);
    }
}
