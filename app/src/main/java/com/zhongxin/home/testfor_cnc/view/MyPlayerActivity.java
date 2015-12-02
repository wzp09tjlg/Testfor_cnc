package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/21.
 */
public class MyPlayerActivity extends Activity  implements
        View.OnClickListener,
        SurfaceHolder.Callback
{
    private final String TAG = "MyPlayerActivity";
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Button mButtonStart;
    private Button mButtonStop;
    private Button mButtonHalt;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myplayer);
        findView();
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //必须在surface创建后才能初始化MediaPlayer,否则不会显示图像
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDisplay(mSurfaceHolder);
        //设置显示视频显示在SurfaceView上
        try {
            AssetFileDescriptor fileDescriptor = getAssets().openFd("yous.mp4");
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_player_start:
                try {
                    mediaPlayer.prepare();  //好像这里也没什么卵用
                    mediaPlayer.reset();
                }catch (Exception e){

                }
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                break;
            case R.id.cnc_btn_player_stop:
                mediaPlayer.pause();
                break;
            case R.id.cnc_btn_player_halt:
                mediaPlayer.stop();  //在网上查询了下  stop之后出现再次点播调用start 方法不起作用。下面的这种方式是就是再stop之后 立马调用prepara
                try{
                    mediaPlayer.prepare(); //好像也不起做用吧 ，奇怪！
                }catch (Exception e){}

                break;
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        //Activity销毁时停止播放，释放资源。不做这个操作，即使退出还是能听到视频播放的声音
    }

    private void findView(){
        mSurfaceView = (SurfaceView) this.findViewById(R.id.cnc_surface);
        mButtonStart = (Button) this.findViewById(R.id.cnc_btn_player_start);
        mButtonStop = (Button) this.findViewById(R.id.cnc_btn_player_stop);
        mButtonHalt = (Button) this.findViewById(R.id.cnc_btn_player_halt);
    }

    private void initView(){
        mButtonStart.setOnClickListener(this);
        mButtonStop.setOnClickListener(this);
        mButtonHalt.setOnClickListener(this);

        mSurfaceHolder=mSurfaceView.getHolder();//SurfaceHolder是SurfaceView的控制接口
        mSurfaceHolder.addCallback(this);//因为这个类实现了SurfaceHolder.Callback接口，所以回调参数直接this
        mSurfaceHolder.setFixedSize(640,480);//显示的分辨率,不设置为视频默认
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//Surface类型
    }
}
