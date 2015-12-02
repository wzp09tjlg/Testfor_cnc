package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

import com.zhongxin.home.testfor_cnc.R;

import java.io.IOException;

/**
 * Created by Walter on 2015/9/21.
 */
public class SurfaceViewNewActivity extends Activity {
        // SurfaceView控件
        private SurfaceView sv_video;

        private SurfaceHolder surfaceHolder;

        // 播放视频对象
        private MediaPlayer mediaPlayer;

        private String path;

        private boolean PasueFlag = false;

        // 记录暂停播放的位置
        private int currentPosition = 0;

        // 播放按钮的控件
        private LinearLayout video_layout;

        //声明一个回放的记录位置
        private int backPosition = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_surface_new);
            // 获取SurfaceView控件
            sv_video = (SurfaceView) findViewById(R.id.sv_video);

            // 通过控件来获取SurfaceHolder
            surfaceHolder = sv_video.getHolder();

            // 回调函数
            surfaceHolder.addCallback(new SurfaceHolder.Callback() {

                // surfaceView控件被销毁的方法
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    // 当点击后退按钮 就杀死 surfaceView控件 activity被杀死

                    //记录视频所播放的位置
                    int position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.release();
                    mediaPlayer = null;

                    //声明意图对象
                    Intent data = new Intent();
                    data.putExtra("position",position);
                    SurfaceViewNewActivity.this.setResult(RESULT_OK, data);

                    //当前kill
                    SurfaceViewNewActivity.this.finish();
                }

                // surfaceView创建的时候执行的方法
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    // 当第一次使用SurfaceView的时候 播放视频
                    play();
                }

                // surfaceView发生变化执行的操作
                @Override
                public void surfaceChanged(SurfaceHolder holder, int format,
                                           int width, int height) {

                }
            });

            // 在这里怎么获取intent传递的数据
            path = this.getIntent().getStringExtra("path");
            backPosition = this.getIntent().getIntExtra("position", 0);

            // 获取LinearLayout的对象
            video_layout = (LinearLayout) findViewById(R.id.video_layout);

            // 隐藏
            video_layout.setVisibility(View.GONE);
        }

        public void playerVideo(View v) {
            play();// 播放视频
        }

        // 视频播放的操作
        public void play() {

            if (PasueFlag) {
                if (mediaPlayer != null) {
                    // 跳转到播放记录的位置
                    mediaPlayer.seekTo(currentPosition);
                    mediaPlayer.start();
                }
                // 变为false
                PasueFlag = false;
            } else {
                // 判断视频 是否为播放状态
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        System.out.println("视频处于播放状态");
                    }
                } else {
                    // 传递的路径 是否为空
                    if (path != null) {
                        try {

                            // 创建视频播放的对象
                            mediaPlayer = new MediaPlayer();

                            /**
                             * 视频播放完成出发的事件
                             */
                            mediaPlayer
                                    .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            mediaPlayer.release();
                                            mediaPlayer = null;
                                            System.out.println(mediaPlayer
                                                    + "------------onCompletion"
                                                    + mp);

                                        }
                                    });

                            /**
                             * 播放出差错的时候触发的事件
                             *
                             * 回调函数
                             */
                            mediaPlayer
                                    .setOnErrorListener(new MediaPlayer.OnErrorListener() {

                                        @Override
                                        public boolean onError(MediaPlayer mp,
                                                               int what, int extra) {
                                            mediaPlayer.release();
                                            mediaPlayer = null;
                                            return false;
                                        }
                                    });

                            // 设计音频流类型
                            mediaPlayer
                                    .setAudioStreamType(AudioManager.STREAM_MUSIC);

                            // 指定播放的文件
                            mediaPlayer.setDataSource(path);
                            // 指定用于播放视频的SurfaceView的控件
                            mediaPlayer.setDisplay(surfaceHolder);
                            mediaPlayer.prepare();

                            //记录上次播放的位置
                            mediaPlayer.seekTo(backPosition);
                            mediaPlayer.start();

                            PasueFlag = false;

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                }
            }

        }

        public void pasueVideo(View v) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                // 记录这个位置
                currentPosition = mediaPlayer.getCurrentPosition();
                // 标识 这视频 会被暂停
                PasueFlag = true;
            }

        }

        public void stopVideo(View v) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                // 暂停标识
                PasueFlag = false;
            }

        }

        public void resetVideo(View v) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }

        }

        // 触摸事件
        public boolean onTouchEvent(MotionEvent event) {
            // 获取布局对象是否是隐藏
            if (View.GONE == video_layout.getVisibility()) {
                video_layout.setVisibility(View.VISIBLE);// 显示
            } else {
                video_layout.setVisibility(View.GONE);// 隐藏
            }
            return super.onTouchEvent(event);
        }
}
