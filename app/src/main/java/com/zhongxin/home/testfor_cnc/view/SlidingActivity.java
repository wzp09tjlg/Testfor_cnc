package com.zhongxin.home.testfor_cnc.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.widget.slidingmenu.SlidingMenu;
import com.zhongxin.home.testfor_cnc.widget.slidingmenu.app.SlidingFragmentActivity;

/**
 * Created by Walter on 2015/9/7.
 */
public class SlidingActivity extends SlidingFragmentActivity
{
    private SlidingMenu menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmenu);
        findView();
        initView();
        initSlidingMenu();
    }

    private void findView(){}

    private void initView(){}

    private void initSlidingMenu(){
        Fragment leftMenuFragment = new LeftMenuFragment();
        setBehindContentView(R.layout.left_menu_layout);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.left_framelayout, leftMenuFragment).commit();
        menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//        menu.setShadowWidthRes(R.dimen.dimen_20dp);  //这是设置侧滑边上的渐变的宽度
//        menu.setShadowDrawable(R.drawable.shadow);   //这是设置侧滑边上渐变的背景
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.dimen_200dp);  //这是设置右边显示contain的宽度
//		menu.setBehindWidth()
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setBehindScrollScale(1);
        menu.setOnOpenListener((LeftMenuFragment)leftMenuFragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT){
            if(menu.isMenuShowing()){
                menu.toggle(true);
            }
        }else if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT){
            if(!menu.isMenuShowing()){
                menu.toggle(true);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

