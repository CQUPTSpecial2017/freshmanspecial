package com.mredrock.freshmanspecial.Ui.View;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.mredrock.freshmanspecial.Model.Special_2017_Circle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/4 0004.
 */

public class Special_2017_MyCircleView extends View {

    private Context mContext;
    private float radius;
    private int percent = 0 ;
    private Paint mStrokePaint = new Paint();
    private Paint mFillPaint = new Paint();
    private Paint mTextPaint = new Paint();
    private Paint mCircleStrokePaint = new Paint();
    private Paint mCircleContentFillPaint = new Paint();
    private Paint mShadowStrokePaint = new Paint();

    private Path mPath;
    private Path mFullPath = new Path();
    private Path mShadowPath ;
    private ArrayList<RectF> mRectFs = new ArrayList<>();
    private RectF mShadowOutRectF ;
    private RectF mShadowInRectF ;
    private float circleWeight = 15 ;
    private float angle ;
    private float maxAngle;
    private int currentPercent = 0;
    private boolean isFirst = true;
    private int width,height;



    private ValueAnimator animation;

    public Special_2017_MyCircleView(Context context) {
        super(context);
        mContext = context;
    }

    public Special_2017_MyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public Special_2017_MyCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }
    public Paint getStrokePaint() {
        return mStrokePaint;
    }

    public Paint getFillPaint() {
        return mFillPaint;
    }

    public Special_2017_MyCircleView setRadius(float radius) {
        this.radius = dip2px(mContext,radius);

        return this;
    }

    public Special_2017_MyCircleView setPercent(int percent) {
        this.percent = percent;
        maxAngle = percent/100*360;
        return this;
    }
    public Special_2017_MyCircleView setColor(String contentColor,String color,String lastContentColor,String lastColor,String shadowColor){
        mFillPaint.setColor(Color.parseColor(contentColor));
        mStrokePaint.setColor(Color.parseColor(color));
        mTextPaint.setColor(Color.parseColor(color));
        mCircleStrokePaint.setColor(Color.parseColor(lastColor));
        mCircleContentFillPaint.setColor(Color.parseColor(lastContentColor));
        mShadowStrokePaint.setColor(Color.parseColor(shadowColor));
        return this;
    }
    public void setCircle(Special_2017_Circle circle){
        setRadius(circle.getRadius()) ;
        setColor(circle.getContentColor(),circle.getColor(),circle.getLastContentColor(),circle.getLastColor(),circle.getShadowColor());
        setPercent(circle.getPercent());

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
        if (isFirst) {
            mPath = new Path();
            mFullPath = new Path();
            mShadowPath = new Path();
            setPaint();


            mPath.setFillType(Path.FillType.EVEN_ODD);

            mFullPath.setFillType(Path.FillType.EVEN_ODD);

            drawPath(canvas);


            isFirst = false;
            startAnimation();

        }else {

            drawPath(canvas);
        }

    }

    private void drawPath(Canvas canvas) {


            mRectFs.clear();
            getRectFs(radius, circleWeight, currentPercent,mRectFs);
            pathAddRectFs(mRectFs, mPath);
            canvas.drawPath(mPath, mStrokePaint);
            canvas.drawPath(mPath, mFillPaint);
            canvas.drawText("%" + percent, width / 2 - 80, mRectFs.get(0).bottom - 5, mTextPaint);


            if (currentPercent == percent){
                //画尾圈
                mFullPath.arcTo(mRectFs.get(2),angle-90,180,false);
                mFullPath.arcTo(mRectFs.get(1),angle-90,360 - angle,false);
                mFullPath.arcTo(mRectFs.get(0),270,-180,false);
                mFullPath.arcTo(mRectFs.get(3),270,angle-360,false);
                canvas.drawPath(mFullPath, mCircleStrokePaint);
                canvas.drawPath(mFullPath, mCircleContentFillPaint);
                canvas.drawPath(mPath, mStrokePaint);
                canvas.drawPath(mPath, mFillPaint);
                canvas.drawText("%" + percent, width / 2 - 80, mRectFs.get(0).bottom-5, mTextPaint);
                mFullPath.reset();

//                //画阴影
//                if (angle<=120 ){
//                    for (int i = 0; i <20 ; i++) {
//                        mShadowOutRectF = new RectF(mRectFs.get(1).left+(i+1),mRectFs.get(1).top+(i+1),mRectFs.get(1).right-(i+1),mRectFs.get(1).bottom-(i+1));
//                        mShadowPath.arcTo(mShadowOutRectF,270,angle,true);
//                        mShadowStrokePaint.setAlpha(200 - 10*i);
//                        canvas.drawPath(mShadowPath,mShadowStrokePaint);
//                        mShadowPath.reset();
//                    }
//
//
//                }
//                else if (angle>120&&angle<=180){
//                    for (int i = 0; i <20 ; i++) {
//                        mShadowOutRectF = new RectF(mRectFs.get(1).left+(i+1),mRectFs.get(1).top+(i+1),mRectFs.get(1).right-(i+1),mRectFs.get(1).bottom-(i+1));
//                        mShadowPath.arcTo(mShadowOutRectF,270,120,true);
//                        mShadowStrokePaint.setAlpha(200 - 10*i);
//                        canvas.drawPath(mShadowPath,mShadowStrokePaint);
//                        mShadowPath.reset();
//                    }
//                }
//                else if (angle>180&&angle<=300){
//                    for (int i = 0; i <20 ; i++) {
//                        mShadowOutRectF = new RectF(mRectFs.get(1).left+(i+1),mRectFs.get(1).top+(i+1),mRectFs.get(1).right-(i+1),mRectFs.get(1).bottom-(i+1));
//                        mShadowPath.arcTo(mShadowOutRectF,270,120,true);
//                        mShadowInRectF = new RectF(mRectFs.get(3).left-(i+1),mRectFs.get(3).top-(i+1),mRectFs.get(3).right+(i+1),mRectFs.get(3).bottom+(i+1));
//                        mShadowPath.arcTo(mShadowInRectF,90,angle-180,true);
//                        mShadowStrokePaint.setAlpha(255 - 10*i);
//                        canvas.drawPath(mShadowPath,mShadowStrokePaint);
//                        mShadowPath.reset();
//                    }
//
//                }else if (angle>300&&angle<=360){
//                    for (int i = 0; i <20 ; i++) {
//                        mShadowOutRectF = new RectF(mRectFs.get(1).left+(i+1),mRectFs.get(1).top+(i+1),mRectFs.get(1).right-(i+1),mRectFs.get(1).bottom-(i+1));
//                        mShadowInRectF = new RectF(mRectFs.get(3).left-(i+1),mRectFs.get(3).top-(i+1),mRectFs.get(3).right+(i+1),mRectFs.get(3).bottom+(i+1));
//                        mShadowPath.arcTo(mShadowOutRectF,270,120,true);
//                        mShadowPath.arcTo(mShadowInRectF,90,120,true);
//                        mShadowStrokePaint.setAlpha(255 - 10*i);
//                        canvas.drawPath(mShadowPath,mShadowStrokePaint);
//                        mShadowPath.reset();
//
//                    }
//                }

                LinearGradient linearGradient = new LinearGradient(width/2+radius,height/2-radius,width/2+radius-circleWeight*Math.abs(2),height/2-radius+circleWeight*Math.abs(2),
                        new int[]{Color.parseColor("#7bf9e6"),mFillPaint.getColor(),Color.parseColor("#b1fef1")},
                        null, Shader.TileMode.CLAMP);

                mFillPaint.setShader(linearGradient);
                canvas.drawPath(mPath, mFillPaint);
            }
    }

    private ArrayList<RectF> getRectFs(float radius,float width,int percent,ArrayList<RectF> mLast){
        width = dip2px(mContext,width);

        int distanceX = this.width/2,distanceY = this.height/2;

        float left ,top ,right ,bottom ,r =  width/2;

        float trueAngle = (float) (percent*2*Math.PI/100);

        left = distanceX -r ;
        top = distanceY - radius ;
        right = distanceX + r ;
        bottom = distanceY - radius + width ;
        RectF startRectF = new RectF(left,top,right,bottom);
        mLast.add(startRectF);

        left = distanceX - radius ;
        top = distanceY - radius;
        right = distanceX + radius;
        bottom = distanceY + radius;
        RectF bigCircleRectF = new RectF(left,top,right,bottom);
        mLast.add(bigCircleRectF);

        left = distanceX + (float) ((radius-r)*(Math.sin(trueAngle)))-r;
        top = distanceY - (float) ((radius-r)*(Math.cos(trueAngle)))-r;
        right = left + width;
        bottom = top + width;
        RectF endRectF= new RectF(left,top,right,bottom);
        mLast.add(endRectF);

        left = distanceX - radius + width;
        top = distanceY - radius +width;
        right = distanceX + radius - width;
        bottom = distanceX+ radius - width ;
        RectF smallCircleRectF = new RectF(left,top,right,bottom);
        mLast.add(smallCircleRectF);
        return mLast;

    }

    private void pathAddRectFs(ArrayList<RectF> rectFs, Path path){
        if (!path.isEmpty())
            path.reset();
        angle = currentPercent*360/100;

            path.arcTo(rectFs.get(0),90,180,false);
            path.arcTo(rectFs.get(1),270,angle,false);
            path.arcTo(rectFs.get(2),angle-90,180,false);
            path.arcTo(rectFs.get(3),angle-90,-angle,false);



    }


    private void setPaint(){

        mFillPaint.setStyle(Paint.Style.FILL);
        mFillPaint.setAntiAlias(true);


        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setAntiAlias(true);
        mStrokePaint.setStrokeWidth(2);

        mTextPaint.setTextSize(dip2px(mContext,10));

        mCircleContentFillPaint.setStyle(Paint.Style.FILL);
        mCircleContentFillPaint.setAntiAlias(true);


        mCircleStrokePaint.setStyle(Paint.Style.STROKE);
        mCircleStrokePaint.setAntiAlias(true);
        mCircleStrokePaint.setStrokeWidth(2);

        mShadowStrokePaint.setStyle(Paint.Style.STROKE);
        mShadowStrokePaint.setAntiAlias(true);
        mShadowStrokePaint.setStrokeWidth(1);

    }



    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void startAnimation() {

        animation = ValueAnimator.ofInt(0,percent);
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator ani) {
                currentPercent = (int)ani.getAnimatedValue() ;
                invalidate();
            }
        });
        animation.setDuration(800);
        animation.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        this.clearAnimation();
        super.onDetachedFromWindow();

    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        this.clearAnimation();
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    protected void onAnimationEnd() {
        isFirst = true;
        super.onAnimationEnd();
    }
}
