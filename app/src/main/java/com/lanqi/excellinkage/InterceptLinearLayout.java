package com.lanqi.excellinkage;

import android.content.Context;
import android.util.AttributeSet;
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        //返回true,则当前LinearLayout拦截了事件，子控件失去了处理事件的能力
        return true;

        //return super.onInterceptTouchEvent(ev); 这个是控件默认的返回，如果放开，则每个item都可以自己处理内部的事件，效果是每个item都可以单独的滑动。
    }

}
