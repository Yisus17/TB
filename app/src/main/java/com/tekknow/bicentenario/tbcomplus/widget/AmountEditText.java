package com.tekknow.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class AmountEditText extends AppCompatEditText {

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

    // -- Validaciones --

    private String getAmountString(){
        return getText().toString();
    }

    private String getAmountClean(){
        return (getAmountString().replace(".", "").replace(",", "."));
    }

    private Double getAmountNumber(){
        return Double.parseDouble(getAmountClean());
    }

    private boolean isEmpty(){
        return (getAmountString() == "");
    }

    private boolean validateRange(Double min, Double max){
        Double amount = getAmountNumber();
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
                    setText(getText().toString().replace(".", "").replace(",", "."));
                } else {
                    if (getText().length() > 0) {
                        DecimalFormat formatter = new DecimalFormat();
                        formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "VE")));
                        formatter.setDecimalSeparatorAlwaysShown(true);
                        formatter.setMinimumFractionDigits(2);

                        setText(formatter.format(Double.parseDouble(getAmountString())));
                    }
                }
            }
        });
    }
}
