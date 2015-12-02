package com.zhongxin.home.testfor_cnc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.zhongxin.home.testfor_cnc.R;

/**
 * Created by Walter on 2015/9/15.
 */
public class SelfView extends View {
    private final String TAG = "SelfView";
    private ImageView icon;
    private Bitmap bitmap;
    private Context mContext;
    private int imgId;
    private int color;
    private float excircleR;
    private float incircleR;
    private Paint mPaint;

    public SelfView(Context context, AttributeSet attrs) {
        super(context, attrs);
        findView(context,attrs);
    }

    private void  findView(Context context,AttributeSet attrs){
        mContext = context;
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SelfView);
        imgId = array.getResourceId(R.styleable.SelfView_imgId,R.drawable.cat3);
        color = array.getColor(R.styleable.SelfView_sideColor,200);
        excircleR = array.getFloat(R.styleable.SelfView_excircleR,50f);
        incircleR = array.getFloat(R.styleable.SelfView_incircleR,40f);
        array.recycle();
        initVew();
    }

    private void initVew(){
         bitmap = ((BitmapDrawable)mContext.getResources().getDrawable(imgId)).getBitmap();
         mPaint = new Paint(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {   //画图都是针对 X 和 Y 轴的，具体控件有多大，这个是得根据在xml布局中定义的大小来画。
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,excircleR,excircleR,mPaint);

    }

    //    public SelfView(Context context) {
//        super(context);
//        findView(context,null);
//    }
//
//    public SelfView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        findView(context,attrs);
//    }
//
//    public SelfView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        findView(context,attrs);
//    }
//
//    //获取自定义view的属性
//    private void findView(Context context, AttributeSet attrs){
//        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SelfView);
//        mContext = context;
//        imgId = array.getResourceId(R.styleable.SelfView_imgId,R.drawable.cat3);
//        color = array.getColor(R.styleable.SelfView_sideColor,200);
//        excircleR = array.getDimension(R.styleable.SelfView_excircleR,50f);
//        incircleR = array.getDimension(R.styleable.SelfView_incircleR,40f);
////        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.cat3));
//        array.recycle();
//        mPaint = new Paint();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
////        super.onDraw(canvas);
////        mPaint.setColor(color);
//////        canvas.drawBitmap(((BitmapDrawable)(mContext.getResources().getDrawable(R.drawable.cat3))).getBitmap(),excircleR,incircleR,mPaint);//画图
////
//////        canvas.drawCircle(300,300,excircleR,mPaint); //画圆
//////        float w=0;
//////        float h=0;
//////        w =  icon.getWidth();
//////        h =  icon.getHeight();
////        canvas.drawCircle(100f,100f,excircleR,mPaint);
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void invalidateWrap() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            postInvalidateOnAnimation();
//        } else {
//            postInvalidate();
//        }
//    }

//    private Paint mPaint;
//
//    private Rect mBounds;
//
//    private int mCount;
//
//    public SelfView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        findView(context, attrs);
//        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mBounds = new Rect();
//        setOnClickListener(this);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
//        mPaint.setColor(Color.YELLOW);
//        mPaint.setTextSize(excircleR);
//        Log.e(TAG,"onDraw()    excircleR:"+excircleR);
//        String text = String.valueOf(mCount);
//        mPaint.getTextBounds(text, 0, text.length(), mBounds);
//        float textWidth = mBounds.width();
//        float textHeight = mBounds.height();
//        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
//                + textHeight / 2, mPaint);
//    }
//
//        //获取自定义view的属性
//    private void findView(Context context, AttributeSet attrs){
//        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SelfView);
//        mContext = context;
//        imgId = array.getResourceId(R.styleable.SelfView_imgId,R.drawable.cat3);
//        color = array.getColor(R.styleable.SelfView_sideColor,200);
//        excircleR = array.getFloat(R.styleable.SelfView_excircleR,50f);
//        Log.e(TAG,"findView()      excircleR:"+excircleR);
//        incircleR = array.getFloat(R.styleable.SelfView_incircleR,40f);
////        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.cat3));
//        array.recycle();
//    }
//
//    @Override
//    public void onClick(View v) {
//        mCount++;
//        invalidate();
//    }
}
