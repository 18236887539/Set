package com.zyh.testtouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ZSwitchButton extends View {

    public ZSwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ZSwitchButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZSwitchButton(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        paint_black = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_black.setColor(Color.parseColor("#969696"));
        paint_black.setStyle(Paint.Style.FILL);
        paint_black.setStrokeWidth(ringWidth);

        paint_gray = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_gray.setColor(Color.parseColor("#E4E4E4"));
        paint_gray.setStyle(Paint.Style.FILL);

        paint_main = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_main.setColor(Color.parseColor("#5577FC"));
        paint_main.setStyle(Paint.Style.FILL);
        paint_main.setStrokeWidth(ringWidth);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ZSwitchButton.this.setChecked(!isChecked);
                if (listener != null) {
                    listener.onChanged(isChecked);
                }
            }
        });
    }

    private int ringWidth = 4;
    boolean isChecked = false;
    Paint paint_black, paint_gray, paint_main;
    private OnCheckedChangeListener listener;

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isChecked) {
            // ª≠‘≤ª∑
            int cx = (int) (width * 3.0f / 4 + 0.5f);
            int cy = (int) (height * 1.0f / 2 + 0.5f);
            canvas.drawCircle(cx, cy, cy - 2, paint_main);
            // ª≠∫·œﬂ
            canvas.drawLine(cx, cy, 0, cy, paint_main);
        } else {
            // ª≠‘≤ª∑
            int cx = (int) (width * 1.0f / 4 + 0.5f);
            int cy = (int) (height * 1.0f / 2 + 0.5f);
            canvas.drawCircle(cx, cy, cy - 2, paint_black);
            // ª≠∫·œﬂ
            canvas.drawLine(cx, cy, width, cy, paint_black);
            // ª≠ƒ⁄‘≤
            canvas.drawCircle(cx, cy, cy - 2 - ringWidth, paint_gray);
        }
    }

    public synchronized void setChecked(boolean checked) {
        isChecked = checked;
        invalidate();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.listener = listener;
    }

    public interface OnCheckedChangeListener {
        public void onChanged(boolean isChecked);
    }

}
