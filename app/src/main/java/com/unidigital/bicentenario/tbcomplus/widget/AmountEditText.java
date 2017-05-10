package com.unidigital.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;


import com.unidigital.bicentenario.tbcomplus.R;
import com.unidigital.bicentenario.tbcomplus.interfaces.KeyboardListener;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class AmountEditText extends AppCompatEditText {

    public static Resources resources;
    private Double minAmount, maxAmount;
    private Context currentContext;
    private KeyboardListener keyboardListener; //Interfaz para posibles modificaciones del onKeyPreIme


    // -------- Constructores --------

    public AmountEditText(Context context) {
        super(context);
        resources = getResources();
        setFocusBehavior();
    }

    public AmountEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        resources = getResources();
        setFocusBehavior();
    }

    public AmountEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resources = getResources();
        setFocusBehavior();
    }

    public void setKeyImeChangeListener(KeyboardListener keyboardListener){
        this.keyboardListener = keyboardListener;
    }


    // -------- Getters, Setters --------

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public Context getCurrentContext() {
        return currentContext;
    }


    // -------- Manejo enventos --------

    //Eventos al presionar alguna tecla sobre el EditText
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //Si se esconde el teclado se quita el foco del edit text
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {

            if(keyboardListener != null){
                keyboardListener.onKeyIme(keyCode, event);
            }

            // Hide cursor
           setFocusable(false);

            // Set EditText to be focusable again
            setFocusable(true);
            setFocusableInTouchMode(true);
        }

        return super.onKeyPreIme(keyCode, event);
    }



    // -------- Transformaciones del monto --------

    //Monto en String
    private String getAmountString(){
        return getText().toString();
    }

    //Monto Doble con formato de miles
    private Double getAmountDouble(){
        return Double.parseDouble(getAmountString());
    }

    //Monto String sin formato de miles
    private String getAmountClean(){
        return (getAmountString().replace(".", "").replace(",", "."));
    }

    //Monto Double sin formato de miles
    private Double getAmountCleanNumber(){
        return Double.parseDouble(getAmountClean());
    }


    //Formato de miles
    private String getAmountFormat(Double amount){
        DecimalFormat formatter = new DecimalFormat();
        formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "VE")));
        formatter.setDecimalSeparatorAlwaysShown(true);
        formatter.setMinimumFractionDigits(2);

        return formatter.format(amount);
    }


    // -------- Validaciones --------

    //Monto vacio
    public boolean isEmpty(){
        return (getAmountString().trim().length() == 0);
    }

    //Monto dentro del rango
    public boolean isValidRange(){
        Double amount = getAmountCleanNumber();
        return (amount <= maxAmount  && amount >= minAmount);
    }

    //Validacion completa
    public fieldValidation validate(){
        String msgError = "";
        boolean isValid = true;

        if(isEmpty()){
            msgError += resources.getString(R.string.no_empty_amount);
            isValid = !isValid;
        }else if(!isValidRange()){
            msgError += resources.getString(R.string.txt_min) + getAmountFormat(minAmount) + "\n" + resources.getString(R.string.txt_max) + getAmountFormat(maxAmount);
            isValid = !isValid;
        }
        fieldValidation fieldValidation = new fieldValidation(msgError, isValid);
        return fieldValidation;
    }


    // -------- Separador --------

    //Al quitar foco, realizar formato de miles en el monto
    private void setFocusBehavior() {
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    setText(getAmountClean());
                } else if (getText().length() > 0) {
                    setText(getAmountFormat(getAmountDouble()));
                }
            }
        });
    }

    // -------- Mostrar mensaje de error en dialog --------

}
