package com.unidigital.bicentenario.tbcomplus.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatEditText;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import com.unidigital.bicentenario.tbcomplus.R;
import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;
import com.unidigital.bicentenario.tbcomplus.interfaces.KeyboardListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.MESSAGE_ERROR;

/**
 * Created by Jesus Arevalo on 5/8/2017.
 */

public class PhoneEditText extends AppCompatEditText {

    public static Resources resources;
    private Context currentContext;
    private KeyboardListener keyboardListener; //Interfaz para posibles modificaciones del onKeyPreIme

    // -------- Constructores --------

    public PhoneEditText(Context context) {
        super(context);
        resources = getResources();
        setTextWatcher();

    }

    public PhoneEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        resources = getResources();
        setTextWatcher();
    }

    public PhoneEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resources = getResources();
        setTextWatcher();
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

    // -------- Transformaciones del telefono --------
    void setTextWatcher(){
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                removeTextChangedListener(this);

                try {
                    String originalString = s.toString();

                    Long longval;

                    longval = Long.parseLong(originalString);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString= PhoneNumberUtils.formatNumber(longval.toString());

                    //setting text after format to EditText

                    if (formattedString.contains(",") || formattedString.contains(" ")) {
                        formattedString.replaceAll(",", "");
                        formattedString.replaceAll(" ", "");
                        setText(formattedString);
                    }
                    Log.i("Formatted",formattedString);
                    Log.i("original",formattedString);

                    setSelection(getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                addTextChangedListener(this);
            }
        });
    }

    // -------- Validacion completa-------

    public boolean isEmpty() {
        String phone= getText().toString().trim();
        boolean isEmpty=true;
        if(phone.length()>0)
            isEmpty=false;
        return isEmpty;
    }

    public boolean validate(){
        String msgError = "";
        boolean isValid = true;

        if(isEmpty()){
            msgError += resources.getString(R.string.no_empty_phone);
            isValid = !isValid;
        }

        if(!isValid){
            GlobalUtilities.displayMessage(msgError, getCurrentContext(), MESSAGE_ERROR);
        }
        return isValid;
    }
}
