package com.mredrock.freshmanspecial.Ui.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class Special_2017_NoScrollViewPager extends ViewPager {
    private boolean noScroll = false;
    private boolean isFirst = true;
    private float downX ;    //按下时 的X坐标
    private float downY ;    //按下时 的Y坐标
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

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //将按下时的坐标存储
                downX = x;
                downY = y;

                break;
            case MotionEvent.ACTION_UP:
                //获取到距离差
                float dx= x-downX;
                float dy = y-downY;

                    orientation = getOrientation(dx, dy);

                break;
            case MotionEvent.ACTION_MOVE:
                if (isFirst){
                    isFirst = false;
                    return false;
                }

                else
                    return super.onTouchEvent(ev);

        }
        if (orientation == 'x' ) {
            noScroll = true;
            return  false;
        }

        else
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {



        /* return false;//super.onTouchEvent(arg0); */

        if (noScroll){
            noScroll = false;
            return false;

        }
        else return super.onTouchEvent(arg0);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
            if (noScroll){
                return true;
            }
            else
            return super.onInterceptTouchEvent(arg0);
    }

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