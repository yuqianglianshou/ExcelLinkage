package com.lanqi.excellinkage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/*
 * 
 * 一个视图容器控件
 * 阻止 拦截 ontouch事件传递给其子控件
 * */
public class InterceptLinearLayout extends LinearLayout {

	public InterceptLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InterceptLinearLayout(Context context) {
		super(context);
	}
//	
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		//return super.dispatchTouchEvent(ev);
//		Log.i("pdwy","ScrollContainer dispatchTouchEvent");
//		return true;
//	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		//return super.onInterceptTouchEvent(ev);
		Log.i("pdwy","ScrollContainer onInterceptTouchEvent");
		return true;
		
		//return super.onInterceptTouchEvent(ev);
	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		Log.i("pdwy","ScrollContainer onTouchEvent");
//		return true;
//	}
}
