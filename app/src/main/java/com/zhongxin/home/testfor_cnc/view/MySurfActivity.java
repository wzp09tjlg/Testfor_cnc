package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Wu on 2015/9/21.
 */
public class MySurfActivity extends Activity  implements
        SurfaceHolder.Callback,
        View.OnClickListener {
    //widget
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Button mButtonStart;
    private Button mButtonStop;
    private Button mButtonCancel;
    //data
    private boolean drawFlag = false;
    private int x, y;

    //interface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysurfaceview);

        findView();
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new  MyThread(mSurfaceHolder,mSurfaceView).run();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cnc_btn_start:
                break;
            case R.id.cnc_btn_stop:
                break;
            case R.id.cnc_btn_cancel:
                break;
        }
    }

    private void findView() {
        mSurfaceView = (SurfaceView) this.findViewById(R.id.cnc_surf_MyVideo);
        mButtonStart = (Button) this.findViewById(R.id.cnc_btn_start);
        mButtonStop = (Button) this.findViewById(R.id.cnc_btn_stop);
        mButtonCancel = (Button) this.findViewById(R.id.cnc_btn_cancel);
    }

    private void initView() {
        mButtonStart.setOnClickListener(this);
        mButtonStop.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
    }

    class MyThread implements Runnable {
        private SurfaceHolder holder;
        private SurfaceView _panel;

        public MyThread(SurfaceHolder holder, SurfaceView panel) {
            this.holder = holder;
            this._panel = panel;
        }

        public boolean onKeyUp(int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            return false;
        }

        public boolean onKeyDown(int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            synchronized (holder) {
                if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
                    y = y - 30;
                } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                    y = y + 30;
                } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
                    x = x - 30;
                } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
                    x = x + 30;
                }
            }
            drawFlag = false;
            return false;
        }

        @Override
        public void run() {
            Canvas c;
            while (true) {
                c = null;
                if (drawFlag) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    continue;
                }
                try {
                    c = holder.lockCanvas(null);
                    synchronized (holder) {
//                        _panel.onDraw(c);
                        Paint p = new Paint(); //创建画笔
                        p.setAntiAlias(true);  //抗锯齿效果
                        p.setColor(Color.GREEN); //颜色
                        c.drawCircle(100f,100f,30f,p);

                        p.setColor(Color.RED);
                        p.setTextSize(30f);
                        c.drawText("this is test for surface!", 150f,150f,p);

                    }
                } finally {
                    if (c != null) {
                        holder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }

}