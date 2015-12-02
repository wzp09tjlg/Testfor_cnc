package com.zhongxin.home.testfor_cnc.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.adapter.KeyPadAdapter;
import com.zhongxin.home.testfor_cnc.bean.PadKeyBean;
import com.zhongxin.home.testfor_cnc.listener.OnItemClickListener;
import com.zhongxin.home.testfor_cnc.widget.KeyItem;
import com.zhongxin.home.testfor_cnc.widget.gridview.VerticalGridView;

/**
 * Created by Wu on 2015/10/14.
 */
public class KeyPadActivity extends Activity implements
        OnItemClickListener<PadKeyBean>
{
    private final String  TAG = "KeyPadActivity";
    //wdiget
    private TextView mTextSearch;
    private VerticalGridView mGridKeyPad;
    //data
    private KeyPadAdapter keyPadAdapter;
    //interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keypad);
        findView();
        initView();
    }

    @Override
    public void onItemClickLister(View view, int position, PadKeyBean padKeyBean) {
        if(padKeyBean.getKeyType().equals(PadKeyBean.KeyType.INPUT))
            doInput(view,padKeyBean);
        else if(padKeyBean.getKeyType().equals(PadKeyBean.KeyType.CLEAR))
            doInput(view,padKeyBean);
        else if(padKeyBean.getKeyType().equals(PadKeyBean.KeyType.DELETE))
            doInput(view,padKeyBean);
    }

    private void findView(){
        mTextSearch = (TextView)this.findViewById(R.id.cnc_text_search);
        mGridKeyPad = (VerticalGridView)this.findViewById(R.id.cnc_grid_keypad);
        keyPadAdapter = new KeyPadAdapter(this,this);
    }

    private void initView(){
       mGridKeyPad.setAdapter(keyPadAdapter);
        mGridKeyPad.requestFocus();
    }

    private void doInput(View view,PadKeyBean bean){
     int length = getResources().getDimensionPixelSize(R.dimen.dimen_160dp);
     int anchorWidth = view.getMeasuredWidth();
        int anchorHeight = view.getMeasuredHeight();
        int offsetx = (length - anchorWidth) / 2;
        int offsety = (length - anchorHeight) / 2;
        KeyItem keyItem = new KeyItem(this);
        keyItem.setPadKeyBean(bean);
        PopupWindow popupWindow = new PopupWindow(keyItem,length,length);
        popupWindow
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.showAsDropDown(view, -offsetx, -offsety);
     }
}
