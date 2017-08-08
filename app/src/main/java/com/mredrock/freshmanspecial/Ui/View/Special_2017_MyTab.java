package com.mredrock.freshmanspecial.Ui.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class Special_2017_MyTab extends TabLayout {

    public Special_2017_MyTab(Context context) {
        super(context);
    }

    public Special_2017_MyTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Special_2017_MyTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint  = new Paint();

        paint.setColor(Color.parseColor("#CCCCCC"));
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        for (int i = 1; i < this.getTabCount(); i++) {
            canvas.drawRect(
                    new Rect(width/this.getTabCount()*i,
                        dip2px(this.getContext(),16),
                        width/this.getTabCount()*i+4,
                        dip2px(this.getContext(),32)),
                    paint);
        }

    }

    public  int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }






}
