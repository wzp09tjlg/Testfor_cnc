package com.zhongxin.home.testfor_cnc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongxin.home.testfor_cnc.R;
import com.zhongxin.home.testfor_cnc.bean.PadKeyBean;
import com.zhongxin.home.testfor_cnc.listener.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Walter on 2015/10/15.
 */
public class KeyPadAdapter extends RecyclerView.Adapter<KeyPadAdapter.ViewHolder> {
    private final String TAG = "KeyPadAdapter";
    private Context mContext;
    private ArrayList<PadKeyBean> mList;
    private OnItemClickListener<PadKeyBean> mOnItemClickListener;
    public KeyPadAdapter(Context context,OnItemClickListener<PadKeyBean> onItemClickListener){
        mContext = context;
        mList = new ArrayList<>();
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("1"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("2").setLetter1("A").setLetter2("B").setLetter3("C"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("3").setLetter1("D").setLetter2("D").setLetter3("F"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("4").setLetter1("G").setLetter2("H").setLetter3("I"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("5").setLetter1("J").setLetter2("K").setLetter3("L"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("6").setLetter1("M").setLetter2("N").setLetter3("O"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("7").setLetter1("P").setLetter2("Q").setLetter3("R").setLetter4("S"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("8").setLetter1("T").setLetter2("U").setLetter3("V"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("9").setLetter1("W").setLetter2("X").setLetter3("Y").setLetter4("Z"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.DELETE).setImg(R.drawable.icon_delete).setLetter1("Delete"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.INPUT).setNum("0"));
        mList.add(new PadKeyBean().setKeyType(PadKeyBean.KeyType.CLEAR).setImg(R.drawable.icon_clear).setLetter1("Clear"));
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_key_layout,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PadKeyBean padKeyBean = mList.get(position);
        if(PadKeyBean.KeyType.INPUT == padKeyBean.getKeyType()){
            holder.mTextNum.setText("" + padKeyBean.getNum());
            holder.mTextDesc.setText("" + padKeyBean.getLetters());
        }else{
            holder.mImgDC.setImageDrawable(mContext.getResources().getDrawable(padKeyBean.getImg()));
            holder.mTextDesc.setText("" + padKeyBean.getLetters());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClickLister(v,position,padKeyBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextNum;
        private ImageView mImgDC;
        private TextView mTextDesc;
        public ViewHolder(View view){
            super(view);
            mTextNum = (TextView)view.findViewById(R.id.cnc_text_search_num);
            mImgDC = (ImageView)view.findViewById(R.id.cnc_img_DC);
            mTextDesc = (TextView)view.findViewById(R.id.cnc_text_search_desc);
        }
    }
}