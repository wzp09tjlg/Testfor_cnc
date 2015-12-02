package com.zhongxin.home.testfor_cnc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.adapter.MenuAdapter;
import com.zhongxin.home.testfor_cnc.bean.MenuBean;
import com.zhongxin.home.testfor_cnc.listener.OnItemClickListener;
import com.zhongxin.home.testfor_cnc.listener.OnItemFocusListener;
import com.zhongxin.home.testfor_cnc.widget.gridview.VerticalGridView;

import java.util.ArrayList;

/**
 * Created by Walter on 2015/8/27.
 */
public class MyFragmentActivity extends FragmentActivity implements
        OnItemClickListener<MenuBean>,
        OnItemFocusListener<MenuBean>
{
    private VerticalGridView menu;
    private FrameLayout contain;
    private MenuAdapter adapter;
    private FragmentAdapter mFragmentAdapter;
    private Fragment tempBaseFragment;
    private Fragment baseFragment;
    private Fragment mCurrentFragment;
    private int mLastPosition=-1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        findView();
        initView();
    }

    @Override
    public void onItemClickLister(View view, int position, MenuBean menuBean) {

    }

    @Override
    public void onItemFocusLister(View view, int position, MenuBean menuBean, boolean hasFocus) {
      if(hasFocus){
          if (tempBaseFragment != null)
          {
              FragmentTransaction transaction = getSupportFragmentManager()
                      .beginTransaction();
              transaction.remove(tempBaseFragment);
              transaction.commit();
          }
          if (position != mLastPosition)
          {
              mFragmentAdapter.startUpdate(contain);
              if (mCurrentFragment != null)
              {
                  mFragmentAdapter.destroyItem(contain, 0,
                          mCurrentFragment);
              }
              mCurrentFragment = (Fragment) mFragmentAdapter
                      .instantiateItem(contain, position);
              mFragmentAdapter.setPrimaryItem(contain, position,
                      mCurrentFragment);
              mFragmentAdapter.finishUpdate(contain);
          }
          mLastPosition = position;
      }
    }

    private void findView(){
        menu = (VerticalGridView)findViewById(R.id.menu);
        contain = (FrameLayout) findViewById(R.id.contain);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        adapter = new MenuAdapter(getMenuData(),this,this);
        menu.requestFocus();
    }

    private void initView(){
        menu.setAdapter(adapter);
    }

    private ArrayList<MenuBean> getMenuData(){
        ArrayList<MenuBean> data = new ArrayList<MenuBean>();
        for(int i=0;i<20;i++){
            MenuBean bean;
            Bundle bundle = new Bundle();
            if(i%2==0){
                bundle.putString("DATA","THIS IS HORIZONAL :"+i);
                bean = new MenuBean("horizolFragment",bundle,Fragment_H.class);
            }
             else{
                bundle.putString("DATA","THIS IS VERTICAL :"+i);
                bean = new MenuBean("VerticalFragment",bundle,Fragment_V.class);
            }
            data.add(bean);
        }
        return data;
    }

    class FragmentAdapter extends FragmentPagerAdapter
    {
        public FragmentAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            return Fragment.instantiate(MyFragmentActivity.this,
                    adapter.getItem(position).fragment.getName(),
                    adapter.getItem(position).bundle);
        }

        @Override
        public int getCount()
        {
            return adapter.getItemCount();
        }
    }
}
