package com.zhongxin.home.testfor_cnc.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;

import de.greenrobot.event.EventBus;

/**
 * Created by Walter on 2015/9/29.
 */
public class ItemDetailFragment2 extends Fragment
{
   private final String TAG = "ItemDetailFragment2";
   private TextView text ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_item_detail,container,false);
        text = (TextView)view.findViewById(R.id.item_detail);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Item item){
       if(item != null){
          text.setText(" -------------> " + item.toString() + "<-----------------");
       }
    }
}
