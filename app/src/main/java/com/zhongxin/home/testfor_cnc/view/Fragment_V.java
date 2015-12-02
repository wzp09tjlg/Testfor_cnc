package com.zhongxin.home.testfor_cnc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/8/27.
 */
public class Fragment_V extends Fragment {

    private TextView text;
    private String textInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_v,container,false);
       findView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        textInfo = getArguments().getString("DATA","");
        text.setText(textInfo);
    }

    private void findView(View view){
        text = (TextView) view.findViewById(R.id.vertical_text);
    }
}
