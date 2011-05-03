package com.slushpupie.deskclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DisplayViewAnalog extends DisplayView {
	
	private Paint paint;
	private boolean showSeconds = false;
	
	
	public DisplayView(Context context) {
		super(context);
		initComponents();
	}
	
	public DisplayView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initComponents();
	}
	
	private void initComponents() {
		paint = new Paint();
		setPadding(1,1,1,1);
	}
	
	public void setShowSeconds(boolean showSeconds) {
		this.showSeconds = showSeconds;
	}
	
	public void update() {
		requestLayout();
		invalidate();
	}
	
	
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }
    
    
    /**
     * Determines the width of this view
     * @param measureSpec A measureSpec packed into an int
     * @return The width of the view, honoring constraints from measureSpec
     */
    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
        	// Take as much space as we can
        	if (specMode == MeasureSpec.AT_MOST) {
        		result = specSize;
        	} else {
        		result = this.getWidth();
        	}
           
        }

        return result;
    }

    /**
     * Determines the height of this view
     * @param measureSpec A measureSpec packed into an int
     * @return The height of the view, honoring constraints from measureSpec
     */
    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            
            if (specMode == MeasureSpec.AT_MOST) {
                result = specSize;
            } else {
            	result = this.getHeight();
            }
        }
        return result;
    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(time == null)
			return;
		
		Rect boundingBox = new Rect(0, 0, 0, 0);
		paint.getTextBounds(time, 0, time.length(), boundingBox);
		
		float horz = (float)(canvas.getWidth() - boundingBox.width()) / 2f;
		float vert = ((float)canvas.getHeight() / 2f) + ((float)boundingBox.height() / 2f);
		
		canvas.drawText(time, horz/2, vert, paint);
		invalidate();
		return;
		
		
	}
	
	
	
}
