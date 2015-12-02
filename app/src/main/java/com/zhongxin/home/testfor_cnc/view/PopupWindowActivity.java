package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/23.
 */
public class PopupWindowActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "PopuWindowActivity";
    //widget
    private Context mContext = this;
    private Button mButtonShow;
    //data
    private String tempStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popupwindow);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_show_popupwindow:
                showPopupWindow(v);
                break;
        }
    }

    private void findView(){
      mButtonShow = (Button)this.findViewById(R.id.cnc_btn_show_popupwindow);
    }

    private void initView(){
        mButtonShow.setOnClickListener(this);
    }

    private void showPopupWindow(View view){
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.view_popuwindow, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 设置按钮的点击事件
        Button button = (Button) contentView.findViewById(R.id.cnc_btn_popupwindow_ok);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "button is pressed",
                        Toast.LENGTH_SHORT).show();
                tempStr = "123321";
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("mengdd", "onTouch : ");
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.cat4));

        // 设置好参数之后再show
//        popupWindow.showAsDropDown(view);  //显示的位置在view的下边
//        popupWindow.showAsDropDown(view,100,100);
//        popupWindow.showAsDropDown(view,200,300, Gravity.BOTTOM);
        popupWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,400,200);
    }
}
