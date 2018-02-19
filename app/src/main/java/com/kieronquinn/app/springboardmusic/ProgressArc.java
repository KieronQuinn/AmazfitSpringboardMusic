package com.kieronquinn.app.springboardmusic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kieron on 19/02/2018.
 */

/*
    Simple View class, containing code to draw an arc matching the shape of the watch (around the bottom notch)
 */
public class ProgressArc extends View {
    public ProgressArc(Context context) {
        super(context);
    }

    public ProgressArc(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressArc(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ProgressArc(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //Default angle is 0
    private int angle = 0;

    //Set the progress to a decimal
    public void setProgress(double progress){
        //Get angle minus notch
        this.angle = (int) Math.round(progress * 345);
        //Redraw
        invalidate();
    }

    //Globals to prevent reloading
    private RectF rectF;
    private Paint foregroundPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Set up rectangle to the size of the screen. Using getWidth twice is intentional, it ignores the notch (which we want)
        if (rectF == null) rectF = new RectF(10, 10, canvas.getWidth() - 10, canvas.getWidth() - 10);
        //Set up the paint
        if (foregroundPaint == null) {
            foregroundPaint = new Paint();
            //Accent colour is the green
            foregroundPaint.setColor(getResources().getColor(R.color.accent));
            //Don't fill the space
            foregroundPaint.setStyle(Paint.Style.STROKE);
            //10px stroke
            foregroundPaint.setStrokeWidth(10);
            //Round the ends of the arc
            foregroundPaint.setStrokeCap(Paint.Cap.ROUND);
        }
        //Draw the arc, starting at 105 deg, to the given angle with the paint
        canvas.drawArc(rectF, 105, angle, false, foregroundPaint);
    }
}
