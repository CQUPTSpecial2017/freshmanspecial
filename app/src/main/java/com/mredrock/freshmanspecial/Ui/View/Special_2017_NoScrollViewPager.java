package com.mredrock.freshmanspecial.Ui.View;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class Special_2017_NoScrollViewPager extends ViewPager {

    private float lastx = 0 ;    //按下时 的X坐标
    private float lasty = 0 ;    //按下时 的Y坐标
    VelocityTracker mVelocityTracker = VelocityTracker.obtain();
    private static final String TAG = "Special_2017_NoScrollVi";
    public Special_2017_NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        float deletx = x- lastx;
        float delety = y - lasty;
        if (getCurrentItem() == 0 &&Math.abs(deletx)>Math.abs(delety)&&ev.getAction()!= MotionEvent.ACTION_MOVE){
            lastx = x;
            lasty = y;
            return true;
        }else {
            lastx = x;
            lasty = y;
            return super.onInterceptTouchEvent(ev);
        }

    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }


}