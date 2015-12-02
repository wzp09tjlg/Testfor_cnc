package com.zhongxin.home.testfor_cnc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.widget.slidingmenu.SlidingMenu;

/**
 * Created by Walter on 2015/9/7.
 */
public class LeftMenuFragment extends Fragment implements
        SlidingMenu.OnOpenListener
{
   private Button mButton1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_menu,container,false);
        findView(view);
        return view;
    }

    private void findView(View view){
        mButton1 = (Button) view.findViewById(R.id.sliding_btn1);
    }


    @Override
    public void onOpen() {
        mButton1.requestFocus();
    }
}
