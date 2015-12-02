package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.MapBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by Walter on 2015/10/12.
 */
public class SortActivity extends Activity implements View.OnClickListener {
    private final String TAG = "SortActivity";
    //widget
    private Button mButtonSort;
    //data
    private List<MapBean> list;
    private Map<String,String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sort);
        findView();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cnc_btn_sort_sort:
                Iterator<String> iterator = map.keySet().iterator();
                while(iterator.hasNext()){
                    String value = iterator.next();
                    System.out.println("value:"+value);
                }
                TreeSet<String> treeSet = new TreeSet<>();
                iterator = map.keySet().iterator();
                System.out.println("1");
                while(iterator.hasNext()){
                    String key = iterator.next();
                    treeSet.add(key);
                }
                System.out.println("2");
                for(String key : treeSet){
                    System.out.println("key:"+key);
                }
                System.out.println("3");
                break;
        }
    }

    private void findView(){
       mButtonSort = (Button)this.findViewById(R.id.cnc_btn_sort_sort);
        list = new ArrayList<MapBean>();
        map = new HashMap<>();
    }

    private void initView(){
        mButtonSort.setOnClickListener(this);
        getData();
    }

    private void getData(){
        MapBean b1 = new MapBean("a","aaaaaa");
        MapBean b2 = new MapBean("0","aaaaaa");
        MapBean b3 = new MapBean("2","aaaaaa");
        MapBean b4 = new MapBean("a2341","aaaaaa");
        MapBean b5 = new MapBean("vdd","aaaaaa");
        MapBean b6 = new MapBean("2a23","aaaaaa");
        MapBean b7 = new MapBean("000a","aaaaaa");
        MapBean b8 = new MapBean("2da","aaaaaa");
        MapBean b9 = new MapBean("avva","aaaaaa");

        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(b7);
        list.add(b8);
        list.add(b9);

        map.put("a","aaaaaa");
        map.put("0","aaaaaa");
        map.put("2","aaaaaa");
        map.put("a2341","aaaaaa");
        map.put("vdd","aaaaaa");
        map.put("2a23","aaaaaa");
        map.put("000a","aaaaaa");
        map.put("2da","aaaaaa");
        map.put("avva","aaaaaa");
    }
}
