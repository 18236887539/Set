package com.zyh.testtouch;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

    private static final String ZSwitchButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This example uses decor view, but you can use any visible view.
        View decorView = getWindow().getDecorView();
        // int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE; //���������С���
        // int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;//���ص�����
        // int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE;//������������������Ҫv19����
        // int uiOptions =
        // View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;//������������������Ҫv19����
        // int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        // int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        // decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);
        // initListview();
        com.zyh.testtouch.ZSwitchButton sw = (ZSwitchButton) findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new ZSwitchButton.OnCheckedChangeListener() {
            @Override
            public void onChanged(boolean isChecked) {
                Log.d("zyh", isChecked + "");
            }
        });
    }

    public void go(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    private void initListview() {
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            data.add("����item��" + i);
        }
        // MyListView mListview = (MyListView) findViewById(R.id.listview);
        // mListview.setAdapter(new ArrayAdapter<String>(this,
        // android.R.layout.simple_list_item_1, data));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result = super.dispatchTouchEvent(ev);
        Log.i("zyh", "activity----dispatchTouchEvent=" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("zyh", "activity----onTouchEvent---down");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i("zyh", "activity----onTouchEvent---move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("zyh", "activity----onTouchEvent---up");
                break;
        }

        boolean result = super.onTouchEvent(event);
        Log.i("zyh", "activity----onTouchEvent=" + result);
        return result;
    }

}
