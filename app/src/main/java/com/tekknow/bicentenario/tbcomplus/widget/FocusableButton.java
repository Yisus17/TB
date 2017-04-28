package com.tekknow.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

public class FocusableButton extends AppCompatButton {

    Actionable actionable;

    public FocusableButton(Context context) {
        super(context);
        init();
    }

    public FocusableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FocusableButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setAction(Actionable actionable){
        this.actionable = actionable;
    }

    public void init(){
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusableInTouchMode(true);
                v.requestFocus();
                v.setFocusableInTouchMode(false);

                actionable.onAction();
            }
        });
    }

    public interface Actionable{
        void onAction();
    }

}
