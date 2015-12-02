package com.zhongxin.home.testfor_cnc.widget.slidingmenu;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Wu on 2015/8/19.
 */
public interface MenuInterface
{
	public abstract void scrollBehindTo(int x, int y, CustomViewBehind cvb,
                                        float scrollScale);

	public abstract int getMenuLeft(CustomViewBehind cvb, View content);

	public abstract int getAbsLeftBound(CustomViewBehind cvb, View content);

	public abstract int getAbsRightBound(CustomViewBehind cvb, View content);

	public abstract boolean marginTouchAllowed(View content, int x,
                                               int threshold);

	public abstract boolean menuOpenTouchAllowed(View content, int currPage,
                                                 int x);

	public abstract boolean menuTouchInQuickReturn(View content, int currPage,
                                                   int x);

	public abstract boolean menuClosedSlideAllowed(int x);

	public abstract boolean menuOpenSlideAllowed(int x);

	public abstract void drawShadow(Canvas canvas, Drawable shadow, int width);

	public abstract void drawFade(Canvas canvas, int alpha,
                                  CustomViewBehind cvb, View content);

	public abstract void drawSelector(View content, Canvas canvas,
                                      float percentOpen);

}
