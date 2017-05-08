package com.unidigital.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;

public class FocusableButton extends AppCompatButton implements View.OnClickListener {

    ActionListener actionListener; //Interfaz para manejar acciones luego de hacer click en el Button


    // -------- Constructores --------

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

    public void setAction(ActionListener actionListener){
        this.actionListener = actionListener;
    }

    // -------- Manejo ClickListener --------

    public void init(){
        setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //Colocar foco en el Button al hacer click (fuerza al format de los EditText)
        v.setFocusableInTouchMode(true);

        //Quitar foco del Button
        v.requestFocus();
        v.setFocusableInTouchMode(false);

        //Acciones al hacer click (Serán definidas en cada Activity)
        actionListener.onAction();
    }
}
