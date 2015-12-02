package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.zhongxin.home.testfor_cnc.R;

import java.io.File;

/**
 * Created by Walter on 2015/9/21.
 */
public class VideoActivity extends Activity {

        private static final int VIDEOREQUESTPLAYER = 1;
        private int position = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);
        }

        public void player(View v) {
            Intent intent = new Intent(VideoActivity.this,
                    SurfaceViewNewActivity.class);
            File sdCardFile = Environment.getExternalStorageDirectory();
            String path = sdCardFile.getPath() + "/Music/oppo.3gp";
            intent.putExtra("path", path);
            intent.putExtra("position", position);
            startActivityForResult(intent, VIDEOREQUESTPLAYER);
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            System.out.println("-------------------onActivityResult");
            // 判断是否是这个请求
            if (VIDEOREQUESTPLAYER == requestCode) {
                // 判断这个请求的响应吗是否成功
                if (RESULT_OK == resultCode) {
                    position = data.getIntExtra("position", 0);
                    System.out.println("==========================" + position);
                }

            }
        }

}
