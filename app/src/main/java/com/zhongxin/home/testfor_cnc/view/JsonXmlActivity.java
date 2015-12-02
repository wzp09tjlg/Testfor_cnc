package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.MapBean;
import com.zhongxin.home.testfor_cnc.utils.FileUtil;
import com.zhongxin.home.testfor_cnc.utils.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Walter on 2015/10/10.
 */
public class JsonXmlActivity extends Activity implements
        View.OnClickListener
{
    private final String TAG = "JsonXmlActivity";
    //widget
    private Button mButtonJson;
    private Button mButtonXml;
    //data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_json_xml);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_xml_json:
                String value =  FileUtil.readAssets(this,"area.json");
                ArrayList<MapBean> list = JsonParser.getJsonParseList(value,"area0");
                for(int i=0;i<list.size();i++){
                    Log.e(TAG,"BEAN:"+list.get(i).toString());
                }
                HashMap<String,List<MapBean>> map = JsonParser.getJsonParseMap(value,"area1");
                for(int i=0;i<map.size();i++){
                    Log.e(TAG,"VALUE:" + map.values().toString());
                }
                break;
            case R.id.cnc_btn_json_xml:
                break;
        }
    }

    private void findView(){
        mButtonJson  = (Button)this.findViewById(R.id.cnc_btn_xml_json);
        mButtonXml = (Button)this.findViewById(R.id.cnc_btn_json_xml);
    }

    private void initView(){
        mButtonJson.setOnClickListener(this);
        mButtonXml.setOnClickListener(this);
    }
}
