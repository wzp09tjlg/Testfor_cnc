package com.zhongxin.home.testfor_cnc.utils;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Walter on 2015/10/23.
 */
public class ToastUtil {
    private final static String TAG = "ToastUtil";
    private static Field field;
    private static Object obj;
    private static Toast toast;
    private static Method showMethod,hideMethod;

    public static void showToast(Context context,String msg,int second){
        toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        Log.e(TAG,"0");
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        try{
            getReflectTN();
            Log.e(TAG,"6");
            showMethod.invoke(obj,null);
            Log.e(TAG,"7");
            Thread.sleep(second);
            Log.e(TAG,"8");
            hideMethod.invoke(obj,null);
            Log.e(TAG,"9");
        }catch (Exception e){
            Log.e(TAG,"10");
        }
    }

    private static void getReflectTN(){
        try{
            Log.e(TAG,"1");
         field = toast.getClass().getDeclaredField("mTN");
            Log.e(TAG,"2");
         field.setAccessible(true);
            Log.e(TAG,"3");
         obj = field.get(toast);
            Log.e(TAG,"4");
            showMethod = obj.getClass().getDeclaredMethod("show",null);
            hideMethod = obj.getClass().getDeclaredMethod("hide",null);
            Log.e(TAG,"5");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e(TAG,"-1");
        }
    }
}
