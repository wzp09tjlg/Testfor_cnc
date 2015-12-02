package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.os.Bundle;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.widget.citypicker.CityPicker;

/**
 * Created by Walter on 2015/9/1.
 */
public class ScollerCityActivity extends Activity {
   private CityPicker cityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scollercity);
        findView();
        initView();
    }

    private void findView(){
        cityPicker = (CityPicker)findViewById(R.id.city_picker);
    }

    private void initView(){}
}
