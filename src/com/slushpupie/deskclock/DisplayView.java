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

public class DisplayView extends View {
	
	private String time;
	
	private Paint paint;
	
	
	public DisplayView(Context context) {
		super(context);
		initComponents();
	}
	
	public DisplayView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initComponents();
	}
}
