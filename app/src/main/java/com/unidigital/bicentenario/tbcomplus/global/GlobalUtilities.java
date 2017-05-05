package com.unidigital.bicentenario.tbcomplus.global;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;
import com.unidigital.bicentenario.tbcomplus.R;

/**
 * Created by Mercedes Rodriguez on 5/5/2017.
 */

public class GlobalUtilities {

    public static AlertDialog alertMessage;

    public static void displayMessage(String message, Context currentContext, int type){

        AlertDialog.Builder alert = new AlertDialog.Builder(currentContext, R.style.AlertDialogCustom);
        LayoutInflater inflater =  LayoutInflater.from(currentContext);
        String titleTxt = "";
        View view = null;

        switch (type){
            case MESSAGE_ERROR:
                view = inflater.inflate(R.layout.dialog_custom_title_error, null);
                titleTxt = currentContext.getString(R.string.error);
                break;
            default:
                view = inflater.inflate(R.layout.dialog_custom_title_info, null);
                titleTxt = currentContext.getString(R.string.info);
                break;
        }

        TextView title=(TextView) view.findViewById(R.id.title);
        title.setText(titleTxt);

        alert.setCustomTitle(view);
        alert.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertMessage = alert.create();
        alertMessage.show();
    }
}
