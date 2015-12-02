package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.utils.ToastUtil;

/**
 * Created by Walter on 2015/10/23.
 */
public class ToastActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "TaostActivity";
    //wdiget
    private Button mButtonShow;
    private Button mButtonHide;
    //data
    //interface


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_self_toast);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.cnc_btn_show:
                ToastUtil.showToast(this,"this is a test for msg to show 5 secoond",5);
                break;
            case R.id.cnc_btn_hide:
                break;
        }
    }

    private void findView(){
        mButtonShow = (Button) this.findViewById(R.id.cnc_btn_show);
        mButtonHide = (Button) this.findViewById(R.id.cnc_btn_hide);
    }

    private void initView(){
        mButtonShow.setOnClickListener(this);
        mButtonHide.setOnClickListener(this);
    }
}
