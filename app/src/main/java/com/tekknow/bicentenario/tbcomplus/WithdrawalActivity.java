package com.tekknow.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class WithdrawalActivity extends BaseActivity {
    EditText fieldAmount;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectAccountType();
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);
        setContentView(R.layout.activity_withdrawal);
    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        super.onCustomerCardRequestResult(status, data);
        requestCustomerPin();
    }

    @Override
    protected void onCustomerPinRequestResult(int status, Bundle data) {
        super.onCustomerPinRequestResult(status, data);
        sendHostRequest();
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);
        displayMessage();
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);
        setResult(RESULT_OK, new Intent());
        finish();
    }

    @Override
    public void onReturn(View view) {
        selectAccountType();
    }

    public void onAccept(View view) {
        fieldAmount=(EditText)findViewById(R.id.txt_amount);
        float amount= Float.parseFloat(fieldAmount.getText().toString());
        if ((amount> GlobalConstants.MIN_AMOUNT_WITHDRAWAL)&&(amount<GlobalConstants.MAX_AMOUNT_WITHDRAWAL)){
            requestCustomerCard();
        }else{
            Toast toast = Toast.makeText(this, "El monto debe ser minimo de "+GlobalConstants.MIN_AMOUNT_WITHDRAWAL+" y maximo de "+GlobalConstants.MAX_AMOUNT_WITHDRAWAL, Toast.LENGTH_SHORT);
            layout = (LinearLayout) toast.getView();
            if (layout.getChildCount() > 0) {
                TextView tv = (TextView) layout.getChildAt(0);
                tv.setGravity(Gravity.CENTER);
            }
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

    }

}