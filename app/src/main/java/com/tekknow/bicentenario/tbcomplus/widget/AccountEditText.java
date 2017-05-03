package com.tekknow.bicentenario.tbcomplus.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.tekknow.bicentenario.tbcomplus.R;
import com.tekknow.bicentenario.tbcomplus.interfaces.KeyboardListener;


/**
 * Created by Jesus Arevalo on 5/3/2017.
 */

public class AccountEditText extends AppCompatEditText {

    public static Resources resources;
    private Context currentContext;
    private KeyboardListener keyboardListener; //Interfaz para posibles modificaciones del onKeyPreIme


    // -------- Constructores --------
    public AccountEditText(Context context) {
        super(context);
        resources = getResources();
    }

    public AccountEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        resources = getResources();
    }

    public AccountEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resources = getResources();
    }

    public void setKeyImeChangeListener(KeyboardListener keyboardListener){
        this.keyboardListener = keyboardListener;
    }

    // -------- Getters y Setters --------

    public Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
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


    // -------- Validacion completa-------

    public boolean isEmpty() {
        String account= getText().toString().trim();
        boolean isEmpty=true;
        if(account.length()>0)
            isEmpty=false;
        return isEmpty;
    }

    public boolean isValidRange(){
        boolean isValidRange=false;
        String account= getText().toString();
        if(account.length()==10)
            isValidRange=true;
        return isValidRange;
    }

    public boolean validate(){
        String msgError = "";
        boolean isValid = true;

        if(isEmpty()){
            msgError += resources.getString(R.string.no_empty_account);
            isValid = !isValid;
        }else if(!isValidRange()){
            msgError += resources.getString(R.string.invalid_account_number);
            isValid = !isValid;
        }

        if(!isValid){
            displayError(msgError);
        }

        return isValid;
    }

    private void displayError(String msgError){

        AlertDialog alertError = null;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getCurrentContext(),R.style.AlertDialogCustom);

        LayoutInflater inflater =  LayoutInflater.from(currentContext);

        View view=inflater.inflate(R.layout.dialog_custom_title, null);
        TextView title=(TextView) view.findViewById(R.id.title);
        title.setText(getCurrentContext().getString(R.string.error));

        alert.setCustomTitle(view);
        alert.setMessage(msgError)
                .setCancelable(false)
                .setNegativeButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertError = alert.create();
        alertError.show();
    }



}
