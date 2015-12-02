package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/10/13.
 */
public class ShareprefenceNewActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "ShareprefenceNewActivity";
    private static final String NAME = "NAME";
    private static final String AGE ="AGE";
    private static final String ADDRESS  = "ADDRESS";
    //widget
    private Button mButtonGet;
    private Button mButtonSave;
    private Button mButtonClear;
    private TextView mText;
    //data
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shareprefence);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_get_prefence:
                pre = getSharedPreferences("MyInfo",MODE_PRIVATE);
//                SharedPreferences.Editor editor = pre.edit();
                String name = "";
                int age  = 0;
                String address ="";
                name = pre.getString(NAME,"defualtStr");
                age  = pre.getInt(AGE,-1);
                address = pre.getString(ADDRESS,"defualtStr");
//                editor.commit();
                mText.setText("name:"+name+"   age:"+age+"  address:"+address   +"   GET!");
                break;
            case R.id.cnc_btn_save_prefence:
                pre = getSharedPreferences("MyInfo",MODE_PRIVATE);
                editor = pre.edit();
                editor.putString(NAME,"BEIJINGWUZHENPENG");
                editor.putInt(AGE,26);
                editor.putString(ADDRESS,"BEIJINGSHANGDIGUIGULIANGCHENG");
                editor.commit();
                mText.setText("name:"+"BEIJINGWUZHENPENG"+"   age:"+26+"  address:"+"BEIJINGSHANGDIGUIGULIANGCHENG"   +"    SAVED!");
                break;
            case R.id.cnc_btn_clear_prefence:
                pre = getSharedPreferences("MyInfo",MODE_PRIVATE);
                editor = pre.edit();
                editor.clear();//清除操作
                editor.commit();
                break;
        }
    }

    private void findView(){
        mButtonGet = (Button)this.findViewById(R.id.cnc_btn_get_prefence);
        mButtonSave = (Button)this.findViewById(R.id.cnc_btn_save_prefence);
        mButtonClear = (Button)this.findViewById(R.id.cnc_btn_clear_prefence);
        mText  = (TextView)this.findViewById(R.id.cnc_text_shareprefence);
    }

    private void initView(){
        mButtonGet.setOnClickListener(this);
        mButtonSave.setOnClickListener(this);
        mButtonClear.setOnClickListener(this);
    }
}
