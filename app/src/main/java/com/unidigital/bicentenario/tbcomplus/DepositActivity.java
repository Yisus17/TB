package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AccountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;


import com.unidigital.bicentenario.tbcomplus.global.GlobalConstants;
import com.unidigital.bicentenario.tbcomplus.model.DepositRequest;

import java.math.BigDecimal;

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

        DepositRequest deposit = new DepositRequest();
        deposit.setAccount("1234567890");
        deposit.setAmount(new BigDecimal(1000000.00));

        Bundle depositData = new Bundle();
        depositData.putInt(GlobalConstants.EXTRA_HOST_REQUEST_ACTION, GlobalConstants.HOST_ACTION_DEPOSIT);
        depositData.putSerializable(GlobalConstants.EXTRA_HOST_REQUEST_DATA, deposit);

        sendHostRequest(depositData);
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