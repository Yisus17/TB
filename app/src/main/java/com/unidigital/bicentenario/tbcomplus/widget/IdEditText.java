package com.unidigital.bicentenario.tbcomplus.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.unidigital.bicentenario.tbcomplus.R;
import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;
import com.unidigital.bicentenario.tbcomplus.interfaces.KeyboardListener;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.MESSAGE_ERROR;

/**
 * Created by Jesus Arevalo on 5/4/2017.
 */

public class IdEditText extends AppCompatEditText {

    public static Resources resources;
    private Context currentContext;
    private KeyboardListener keyboardListener; //Interfaz para posibles modificaciones del onKeyPreIme


    // -------- Constructores --------

    public IdEditText(Context context) {
        super(context);
        resources = getResources();
        setFocusBehavior();
    }

    public IdEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        resources = getResources();
        setFocusBehavior();
    }

    public IdEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resources = getResources();
        setFocusBehavior();
    }

    public void setKeyImeChangeListener(KeyboardListener keyboardListener){
        this.keyboardListener = keyboardListener;
    }

    // -------- Getters, Setters --------

    public Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    // -------- Transformaciones del monto --------

    //Monto en String
    private String getIdString(){
        return getText().toString();
    }

    //Monto Doble con formato de miles
    private Double getIdDouble(){
        return Double.parseDouble(getIdString());
    }

    //Monto String sin formato de miles
    private String getIdClean(){
        return (getIdString().replace(".", "").replace(",", "."));
    }

    //Formato de miles
    private String getIdFormat(Double id){
        DecimalFormat formatter = new DecimalFormat();
        formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "VE")));
        formatter.setDecimalSeparatorAlwaysShown(true);
        formatter.setMinimumFractionDigits(0);

        return formatter.format(id);
    }


    // -------- Validacion completa-------

    public boolean isEmpty() {
        String id= getText().toString().trim();
        boolean isEmpty=true;
        if(id.length()>0)
            isEmpty=false;
        return isEmpty;
    }

    public fieldValidation validate(){
        String msgError = "";
        boolean isValid = true;

        if(isEmpty()){
            msgError += resources.getString(R.string.no_empty_id);
            isValid = !isValid;
        }

        fieldValidation fieldValidation = new fieldValidation(msgError, isValid);
        return fieldValidation;

    }

    //Al quitar foco, realizar formato de miles en el monto
    private void setFocusBehavior() {
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    setText(getIdClean());
                } else if (getText().length() > 0) {
                    String idText= getIdFormat(getIdDouble());
                    setText(idText.substring(0,idText.length()-1));
                }
            }
        });
    }
}
