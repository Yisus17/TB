package com.tekknow.bicentenario.tbcomplus.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class SignatureView extends View {

    float x = 0;
    float y = 0;

    String action = "action";

    Path path = new Path();

    public SignatureView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);

        if (action == "down") {
            path.moveTo(x, y);
        } else if (action == "move") {
            path.lineTo(x, y);
        } else if (action == "clear") {
            path.reset();
        }

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            action = "down";
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            action = "move";
        }

        invalidate();
        return true;
    }

    public void clear() {
        action = "clear";
        invalidate();
    }

}