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
    private boolean noScroll = true;
    private float downX ;    //按下时 的X坐标
    private float downY ;    //按下时 的Y坐标
    VelocityTracker mVelocityTracker = VelocityTracker.obtain();
    private static final String TAG = "Special_2017_NoScrollVi";
    public Special_2017_NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public Special_2017_NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int orientation = 0 ;
        //在触发时回去到起始坐标
        float x= ev.getX();
        float y = ev.getY();
        mVelocityTracker.addMovement(ev);
        mVelocityTracker.computeCurrentVelocity(1000);
        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                //将按下时的坐标存储
//                downX = x;
//                downY = y;
//
//                break;
//            case MotionEvent.ACTION_UP:
//                //获取到距离差
//                float dx= x-downX;
//                float dy = y-downY;
//
//                    orientation = getOrientation(dx, dy);
//
//                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }


            Log.d(TAG, "dispatchTouchEvent: "+(Math.abs(mVelocityTracker.getXVelocity()) >Math.abs(mVelocityTracker.getYVelocity())));
            Log.d(TAG, "dispatchTouchEvent: "+Math.abs(mVelocityTracker.getXVelocity()) +"Y:"+Math.abs(mVelocityTracker.getYVelocity()));
            if(Math.abs(mVelocityTracker.getXVelocity())>Math.abs(mVelocityTracker.getYVelocity())) {
                Log.d(TAG, "dispatchTouchEvent: ");

                return false;
            }

        return false;

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent arg0) {
//
//
//
//        /* return false;//super.onTouchEvent(arg0); */
//
//        if (noScroll){
//
//            return false;
//
//        }
//        else return super.onTouchEvent(arg0);
//
//    }



    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    private int getOrientation(float dx, float dy) {

        if (Math.abs(dx)>8){
            //X轴移动
            return 'x';
        }else{
            //Y轴移动
            return 'y';
        }
    }

}