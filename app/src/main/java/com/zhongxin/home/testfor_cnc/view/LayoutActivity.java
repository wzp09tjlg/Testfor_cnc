package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Wu on 2015/10/8.
 */
public class LayoutActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "LayoutActivity";
    //widget
    private Button mButtonUp;
    private Button mButtonCenter;
    private Button mButtonLeft;
    private Button mButtonRight;
    private Button mButtonDown;
    //data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_up:
                Toast.makeText(this,"up",Toast.LENGTH_LONG).show();
                break;
            case R.id.cnc_btn_center:
                Toast.makeText(this,"center",Toast.LENGTH_LONG).show();
                break;
            case R.id.cnc_btn_left:
                Toast.makeText(this,"left",Toast.LENGTH_LONG).show();
                break;
            case R.id.cnc_btn_right:
                Toast.makeText(this,"right",Toast.LENGTH_LONG).show();
                break;
            case R.id.cnc_btn_down:
                Toast.makeText(this,"down",Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void findView(){
        mButtonUp = (Button)this.findViewById(R.id.cnc_btn_up);
        mButtonCenter = (Button)this.findViewById(R.id.cnc_btn_center);
        mButtonLeft = (Button)this.findViewById(R.id.cnc_btn_left);
        mButtonRight = (Button)this.findViewById(R.id.cnc_btn_right);
        mButtonDown = (Button)this.findViewById(R.id.cnc_btn_down);
    }
    private void initView(){
        mButtonUp.setOnClickListener(this);
        mButtonCenter.setOnClickListener(this);
        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mButtonDown.setOnClickListener(this);
    }
}
