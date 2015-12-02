package com.zhongxin.home.testfor_cnc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.PadKeyBean;

/**
 * Created by Walter on 2015/10/14.
 */
public class KeyItem extends RelativeLayout {
    private final String TAG = "";
    //widget
    private ImageView img;
    private TextView textNum;
    private TextView textLetter1;
    private TextView textLetter2;
    private TextView textLetter3;
    private TextView textLetter4;
    //data
    private PadKeyBean padKeyBean;
    private DoCallBack mDoCallBack;
    //interface
    public KeyItem(Context context) {
        super(context);
        initView(context);
    }

    public KeyItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public KeyItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        View view  = LayoutInflater.from(context).inflate(R.layout.item_key_layout,null,true);
        img = (ImageView) view.findViewById(R.id.cnc_img_pad_item);
        textNum = (TextView) view.findViewById(R.id.text_center);
        textLetter1 = (TextView) view.findViewById(R.id.text_left);
         textLetter2 = (TextView) view.findViewById(R.id.text_top);
         textLetter3 = (TextView) view.findViewById(R.id.text_right);
         textLetter4 = (TextView) view.findViewById(R.id.text_bottom);
        addView(view);
    }

    public void setPadKeyBean(PadKeyBean padKeyBean){
        this.padKeyBean = padKeyBean;
    }

    public void setmDoCallBack(DoCallBack doCallBack){
        mDoCallBack = doCallBack;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            img.setImageLevel(1);
            mDoCallBack.doCallBack();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (padKeyBean.getLetter1() != null) {
                img.setImageLevel(2);
            }
            mDoCallBack.doCallBack();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            if (padKeyBean.getLetter2() != null) {
                img.setImageLevel(3);
            }
            mDoCallBack.doCallBack();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (padKeyBean.getLetter3() != null) {
                img.setImageLevel(4);
            }
            mDoCallBack.doCallBack();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (padKeyBean.getLetter4() != null) {
                img.setImageLevel(5);
            }
            mDoCallBack.doCallBack();
        }
        return super.onKeyDown(keyCode, event);
    }

    public interface DoCallBack{
        public void doCallBack();
    }

}
