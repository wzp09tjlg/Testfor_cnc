package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.Person;
import com.zhongxin.home.testfor_cnc.utils.Compare;
import com.zhongxin.home.testfor_cnc.utils.LogUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Walter on 2015/7/25.
 */
public class ShareprefenceActivity extends Activity  implements View.OnClickListener{
    private final String TAG = "ShareprefenceActivity";
    private Button mButtonSave;
    private Button mButtonRead;
    private Button mButtonSort;
    private Button mButtonShowData;
    private ArrayList<Person> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sharepefence);
        findView();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.cnc_btn_save_shareprefence:
                //保存八大数据基本类型
                SharedPreferences sharePrefence = getSharedPreferences("SHAREPREFENCE",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharePrefence.edit();
                editor.putInt("INT",100);
                editor.putLong("LONG", 10000l);
                editor.putFloat("FLOAT", 1111.11f);
                editor.putBoolean("BOOLEAN", true);
                editor.putString("STRING", "ANDROID");
                LogUtil.LogE(TAG,"shareprefence is saved!");
                editor.commit();
                break;
            case R.id.cnc_btn_read_shareprefence:
                SharedPreferences sharedPreferences = getSharedPreferences("SHAREPREFENCE", MODE_PRIVATE);
                LogUtil.LogE(TAG,"INT:"+sharedPreferences.getInt("INT",-1));
                LogUtil.LogE(TAG,"LONG:"+ sharedPreferences.getLong("LONG",-1L));
                LogUtil.LogE(TAG,"FLOAT:"+sharedPreferences.getFloat("FLOAT",-1.0F));
                LogUtil.LogE(TAG,"BOOLEAN:"+sharedPreferences.getBoolean("BOOLEAN", false));
                LogUtil.LogE(TAG,"STRING:"+sharedPreferences.getString("STRING","android"));
                break;
            case R.id.cnc_btn_showData:
                LogUtil.LogE(TAG,"check data of mList:");
                for(int i=0;i<mList.size();i++)
                LogUtil.LogE(TAG,"Person:"+mList.get(i));
                break;
            case R.id.cnc_btn_sort_shareprefence:
                LogUtil.LogE(TAG,"begin sort:");
                if(mList!=null)
                    Collections.sort(mList,new Compare<Person>());
                break;
        }
    }

    private void findView(){
        mButtonSave = (Button) this.findViewById(R.id.cnc_btn_save_shareprefence);
        mButtonRead = (Button) this.findViewById(R.id.cnc_btn_read_shareprefence);
        mButtonSort = (Button) this.findViewById(R.id.cnc_btn_sort_shareprefence);
        mButtonShowData = (Button) this.findViewById(R.id.cnc_btn_showData);
        mList = getData();
    }

    private void initView(){
        mButtonSave.setOnClickListener(this);
        mButtonRead.setOnClickListener(this);
        mButtonSort.setOnClickListener(this);
        mButtonShowData.setOnClickListener(this);
    }

    private ArrayList<Person> getData(){
        ArrayList<Person> data = new ArrayList<Person>();

        for(int i=0;i<10;i++){
            Person person = new Person.Builder().setId(i).setName(getStr(10)).setAge(i*123%98).setAddress(getStr(20)).build();
            data.add(person);
        }
      return data;
    }

    private  String getStr(int len){
      String str="dfhsajfhoqbdhsalccoeheuwancjdslfhuencjdslznc na iis ncsac fy csafua csknfuebcj nupdw cjneo skhf3jfhnanmknzfue";
      String result="";
        for(int i=0;i<len;i++){
            int random =(int) Math.random()*100;
            result = result + str.substring(random,random+1);
        }
        return result;
    }
}
