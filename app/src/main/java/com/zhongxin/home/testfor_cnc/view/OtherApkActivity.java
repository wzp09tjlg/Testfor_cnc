package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/10/8.
 */
public class OtherApkActivity extends Activity  implements
        View.OnClickListener
{
    private final String TAG = "OtherPakActivity";
    //widget
    private Button mButtonFileManager;
    private Button mButtonOtherApk;
    //data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goto_other_apk);

        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_file_manager:
                try{
                    ComponentName componentName = new ComponentName("cn.cncgroup.filemanager","com.voole.multimedia.startup");
                Intent intentFileManager = new Intent();
                intentFileManager.setComponent(componentName);
                startActivity(intentFileManager);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.cnc_btn_other_apk:
               try{
                   ComponentName componentName1 = new ComponentName("cn.cncgroup.filemanager","com.cncgroup.filemanager.DiskActivity");
                   Intent intentDisk = new Intent();
                   intentDisk.setComponent(componentName1);
                   startActivity(intentDisk);
               }catch (Exception e){
                   e.printStackTrace();}
                break;
        }
    }

    private void findView(){
       mButtonFileManager = (Button)this.findViewById(R.id.cnc_btn_file_manager);
        mButtonOtherApk   = (Button)this.findViewById(R.id.cnc_btn_other_apk);
    }

    private void initView(){
        mButtonFileManager.setOnClickListener(this);
        mButtonOtherApk.setOnClickListener(this);
    }
}
