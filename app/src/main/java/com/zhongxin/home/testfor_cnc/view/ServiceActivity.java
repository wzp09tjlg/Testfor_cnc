package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.widget.MyService;

/**
 * Created by Walter on 2015/7/27.
 */
public class ServiceActivity  extends Activity implements View.OnClickListener {
    private final String TAG  = "ServiceActivity";
    private final int START_CODE = 10010;
    private final int STOP_CODE = 10011;
    private Button mButtonStartService;
    private Button mButtonStopService;
    private MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_service);
        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.cnc_btn_start_service:
                Intent intentStartService = new Intent(ServiceActivity.this,CommonService.class);
                intentStartService.putExtra("BYTE",1);
                intentStartService.putExtra("SHORT",10);
                intentStartService.putExtra("INT",100);
                intentStartService.putExtra("LONG",1000l);
                intentStartService.putExtra("FLOAT",100.11f);
                intentStartService.putExtra("DOUBLE",1000.111d);
                intentStartService.putExtra("CHAR",'A');
                intentStartService.putExtra("BOOLEAN",true);
                intentStartService.putExtra("STRING","ANDROID");
                startService(intentStartService);
                break;
            case R.id.cnc_btn_stop_service:
                Intent intentStopService = new Intent(ServiceActivity.this,CommonService.class);
                stopService(intentStopService);
                break;
        }
    }

    private void findView(){
        mButtonStartService = (Button) this.findViewById(R.id.cnc_btn_start_service);
        mButtonStopService = (Button) this.findViewById(R.id.cnc_btn_stop_service);
    }

    private void initView(){
        myService = new MyService();
        mButtonStartService.setOnClickListener(this);
        mButtonStopService.setOnClickListener(this);
    }
}
