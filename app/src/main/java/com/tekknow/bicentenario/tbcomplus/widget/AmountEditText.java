package com.tekknow.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;


import com.tekknow.bicentenario.tbcomplus.interfaces.KeyboardListener;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class AmountEditText extends AppCompatEditText {

    private KeyboardListener keyboardListener;

    // -- Constructores --

    public AmountEditText(Context context) {
        super(context);
        setFocusBehavior();
    }

    public AmountEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusBehavior();
    }

    public AmountEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusBehavior();
    }

    // -- Manejo enventos --

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {

            if(keyboardListener != null){
                keyboardListener.onKeyIme(keyCode, event);
            }

            // Hide cursor
           /*setFocusable(false);

            // Set EditText to be focusable again
            setFocusable(true);
            setFocusableInTouchMode(true);*/
        }

        return super.onKeyPreIme(keyCode, event);
    }

    public void setKeyImeChangeListener(KeyboardListener listener){
        keyboardListener = listener;
    }


    // -- Transformaciones del monto --

    private String getAmountString(){
        return getText().toString();
    }

    private Double getAmountDouble(){
        return Double.parseDouble(getAmountString());
    }

    private String getAmountClean(){
        return (getAmountString().replace(".", "").replace(",", "."));
    }

    private Double getAmountCleanNumber(){
        return Double.parseDouble(getAmountClean());
    }

    private String getAmountFormat(){
        DecimalFormat formatter = new DecimalFormat();
        formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "VE")));
        formatter.setDecimalSeparatorAlwaysShown(true);
        formatter.setMinimumFractionDigits(2);

        return formatter.format(getAmountDouble());
    }

    // -- Validaciones --

    private boolean isEmpty(){
        return (getAmountString() == "");
    }

    private boolean validateRange(Double min, Double max){
        Double amount = getAmountCleanNumber();
        return (amount <= max  && amount >= min);
    }

    public boolean isValidAmount(Double min, Double max){
        return (!isEmpty() && validateRange(min, max));
    }


    // -- Separador --

    private void setFocusBehavior() {
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    setText(getAmountClean());
                } else if (getText().length() > 0) {
                    setText(getAmountFormat());
                }
            }
        });
    }
}
