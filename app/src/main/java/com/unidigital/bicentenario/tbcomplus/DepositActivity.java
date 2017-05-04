package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AccountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;


public class DepositActivity extends TransactionActivity {

    public final Double MAX_AMOUNT = 5000.40;
    public final Double MIN_AMOUNT = 1040.32;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        FocusableButton executeDeposit = (FocusableButton) findViewById(R.id.btn_execute_deposit);

        executeDeposit.setAction(new ActionListener() {
            @Override
            public void onAction() {
                AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);

                amountEditText.setMinAmount(MIN_AMOUNT);
                amountEditText.setMaxAmount(MAX_AMOUNT);
                amountEditText.setCurrentContext(context);

                AccountEditText accountEditText= (AccountEditText) findViewById(R.id.input_account);
                accountEditText.setCurrentContext(context);

                if((accountEditText.validate()) && (amountEditText.validate()))
                    requestUserCard();
            }
        });
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        super.onUserCardRequestResult(status, data);
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        super.onUserPinRequestResult(status, data);
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
    protected int getLayout() {
        return R.layout.activity_deposit;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_deposit);
    }
}