package com.mredrock.freshmanspecial.Ui.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class Special_2017_MyChangeAlpha extends View {
    int width,height;
    public Special_2017_MyChangeAlpha(Context context) {
        super(context);
    }

    public Special_2017_MyChangeAlpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Special_2017_MyChangeAlpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Special_2017_MyChangeAlpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {         //如果没有指定大小，就设置为默认大小
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {             //如果测量模式是最大取值为size
                mySize = size;
                break;
            }
            case MeasureSpec.EXACTLY: {             //如果是固定的大小，那就不要去改变它
                mySize = size;
                break;
            }
        }
        return mySize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMySize(100, widthMeasureSpec);
        height = getMySize(100, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        for (int i = 0; i < width; i++) {
            p.setColor(Color.BLACK);
            p.setStrokeWidth(1);
        }
        super.onDraw(canvas);
    }
}
