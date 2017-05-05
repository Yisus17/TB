package com.unidigital.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

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

        if(status == STATUS_BACK){
            onReturn();
        }else{
            setContentLayout(R.layout.activity_withdrawal);
        }
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
    protected int getLayout() {
        return -1;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_withdrawal);
    }

    @Override
    public void onAccept(View view) {
        fieldAmount = (EditText) findViewById(R.id.txt_amount);
        String txtAmount = fieldAmount.getText().toString();
        Toast toast;
        if(txtAmount.trim().length() == 0){
            GlobalUtilities.displayMessage(getString(R.string.no_empty_amount), this, MESSAGE_ERROR);
        }else{
            float amount= Float.parseFloat(txtAmount);

            if ((amount > MIN_AMOUNT_WITHDRAWAL)&&(amount < MAX_AMOUNT_WITHDRAWAL)){
                requestCustomerCard();
            }else{
                String message = getString(R.string.txt_min) + MIN_AMOUNT_WITHDRAWAL+ "\n" + getString(R.string.txt_max) + MAX_AMOUNT_WITHDRAWAL;
                GlobalUtilities.displayMessage(message, this, MESSAGE_ERROR);
            }
        }
    }
}