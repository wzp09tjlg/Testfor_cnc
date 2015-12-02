package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.api.checknum.ShowApiRequest;

import org.apache.http.Header;

/**
 * Created by Walter on 2015/9/14.
 */
public class CheckNumActivity extends Activity  implements
        View.OnClickListener
{
    private final String TAG = "CheckNumActivity";
    //widget
    private Button mButtonCheckNum;
    //data
    final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
    //回调接口
        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
            try {
             Log.d(TAG,"bytes:"+new String(bytes));
                //在此对返回内容做处理
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            throwable.printStackTrace();
        }
    };
    //interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_number);

        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cnc_btn_check_number_local:
                new ShowApiRequest( "http://route.showapi.com/6-1", "9196", "41f935a8943441a69f2e9c79da52b942")
                        .setResponseHandler(resHandler)
                        .addTextPara("num","15210521539")
                        .post();
                break;
        }
    }

    private void findView(){
        mButtonCheckNum = (Button) this.findViewById(R.id.cnc_btn_check_number_local);
    }

    private void initView(){
        mButtonCheckNum.setOnClickListener(this);
    }
}
