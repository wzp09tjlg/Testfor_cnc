package com.zhongxin.home.testfor_cnc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.MenuBean;
import com.zhongxin.home.testfor_cnc.listener.OnItemClickListener;
import com.zhongxin.home.testfor_cnc.listener.OnItemFocusListener;

import java.util.ArrayList;

/**
 * Created by Walter on 2015/8/27.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
   private ArrayList<MenuBean> mList;
   private OnItemFocusListener<MenuBean> mOnItemFocusListener;
    private OnItemClickListener<MenuBean> mOnItemClickListener;
    public MenuAdapter(ArrayList<MenuBean> list,OnItemFocusListener<MenuBean> onItemFocusListener,OnItemClickListener<MenuBean>onItemClickListener){
        mList = list;
        mOnItemFocusListener = onItemFocusListener;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MenuBean bean = mList.get(position);
        holder.menu.setText(bean.getName());
        holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mOnItemFocusListener.onItemFocusLister(view,position,bean,b);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClickLister(view,position,bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public MenuBean getItem(int position){
        return mList.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView menu;
        public ViewHolder(View view){
            super(view);
            menu = (TextView)view.findViewById(R.id.menu_item_text);
        }
    }
}
