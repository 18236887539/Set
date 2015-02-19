package com.zyh.testtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        Log.i("zyh", "ListView----dispatchTouchEvent=" + result);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        Log.i("zyh", "ListView----dispatchTouchEvent=" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("zyh", "ListView----onTouchEvent---down");
            break;

            case MotionEvent.ACTION_MOVE:
                Log.i("zyh", "ListView----onTouchEvent---move");
            break;
            case MotionEvent.ACTION_UP:
                Log.i("zyh", "ListView----onTouchEvent---up");
            break;
        }

        boolean result = super.onTouchEvent(event);
        Log.i("zyh", "ListView----onTouchEvent=" + result);
        return result;
    }

}
