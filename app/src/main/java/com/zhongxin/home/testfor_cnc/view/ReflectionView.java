package com.zhongxin.home.testfor_cnc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/7/27.
 */
public class ReflectionView extends FrameLayout {

    public ReflectionView(Context context) {
        super(context);
        findView(context);
    }

    public ReflectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        findView(context);
    }

    public ReflectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        findView(context);
    }

    private void findView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.view_reflection,this,true);
        new Thread(new MyRunnable()).start();
    }

    private void initView(){}

    //画背景处理
    private void onDraweBackgroud(){
        int x,y;
        x = getWidth();
        y = getHeight();
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0,x,0,y,0x800000ff,0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        int X,Y;
        X = 100;
        Y = 200;
        Bitmap bitmap=Bitmap.createBitmap(X, Y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();

        Rect rect = new Rect();
//        canvas.drawRect(rect,paint);
        canvas.drawRect(0, 0, x, y, paint);
        requestLayout();
    }

    class MyRunnable implements  Runnable{
        @Override
        public void run() {
            onDraweBackgroud();
        }
    }



}
