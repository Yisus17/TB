package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class WithdrawalActivity extends TransactionActivity {

    EditText fieldAmount;
    Toast toast;

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
        onAccept();
    }

    @Override
    public void onReturn(View view) {
        selectAccountType();
    }

    @Override
    public void onAccept(View view) {
        fieldAmount = (EditText) findViewById(R.id.txt_amount);
        String txtAmount = fieldAmount.getText().toString();

        if(txtAmount.trim().length() == 0){
            toast = Toast.makeText(this, getString(R.string.no_empty_amount), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }else{
            float amount= Float.parseFloat(txtAmount);

            if ((amount> GlobalConstants.MIN_AMOUNT_WITHDRAWAL)&&(amount<GlobalConstants.MAX_AMOUNT_WITHDRAWAL)){
                requestCustomerCard();
            }else{
                toast = Toast.makeText(this, getString(R.string.txt_min) + GlobalConstants.MIN_AMOUNT_WITHDRAWAL+ "\n" + getString(R.string.txt_max) + GlobalConstants.MAX_AMOUNT_WITHDRAWAL, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        }
    }
}