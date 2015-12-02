package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Walter on 2015/9/18.
 */
public class SurfaceViewActivity extends Activity {
    private final String TAG = "SurfaceViewActivity";
        private MyView myView;
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            super.onCreate(savedInstanceState);
            myView = new MyView(this);
            setContentView(myView);
        }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_DPAD_UP){
            if(myView.isRun()){
                myView.setRun(false);
                Log.e(TAG,"SET FALSE1");
            }else{
                myView.setRun(false);
                Log.e(TAG,"SET TRUE2");
            }
            Log.e("TAG", "-------------------------------------------------------");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

        //视图内部类
        class MyView extends SurfaceView implements SurfaceHolder.Callback
        {
            private SurfaceHolder holder;
            private MyThread myThread;
            public MyView(Context context) {
                super(context);
                // TODO Auto-generated constructor stub
                holder = this.getHolder();
                holder.addCallback(this);
                myThread = new MyThread(holder);//创建一个绘图线程
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                // TODO Auto-generated method stub

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                myThread.isRun = true;
                myThread.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                myThread.isRun = false;
            }

            public boolean isRun(){
              if(myThread.getIsRun()){
                  Log.e(TAG,"Get MyThread   return true");
                  return true;}
              else{
                  Log.e(TAG,"Get MyThread   return false");
                  return false;}
            }

            public void setRun(boolean value){
                myThread.setIsRun( value);
            }
        }
        //线程内部类
        class MyThread extends Thread
        {
            private SurfaceHolder holder;
            public boolean isRun ;
            public  MyThread(SurfaceHolder holder)
            {
                this.holder =holder;
                isRun = true;
            }

            public boolean getIsRun(){
                return isRun;
            }

            public void setIsRun(boolean value){
                isRun = value;
            }

            @Override
            public void run()
            {
                int count = 0;
                while(isRun)
                {
                    Canvas c = null;
                    try
                    {
                        synchronized (holder)
                        {
                            c = holder.lockCanvas();//锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
                            c.drawColor(Color.BLACK);//设置画布背景颜色
                            Paint p = new Paint(); //创建画笔
                            p.setColor(Color.WHITE);
                            Rect r = new Rect(100, 50, 300, 250);
                            c.drawRect(r, p);

                            p.setAntiAlias(true); //抗锯齿
                            p.setTextSize(50);
                            p.setColor(Color.RED);
                            c.drawText(""+(count++),170,180,p);

                            p.setTextSize(20);
                            p.setColor(Color.WHITE);
                            c.drawText("这是第"+(count)+"秒", 100, 310, p);
                            Thread.sleep(1000);//睡眠时间为1秒
                        }
                    }
                    catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    finally
                    {
                        if(c!= null)
                        {
                            holder.unlockCanvasAndPost(c);//结束锁定画图，并提交改变。

                        }
                    }
                }
            }
        }
}
