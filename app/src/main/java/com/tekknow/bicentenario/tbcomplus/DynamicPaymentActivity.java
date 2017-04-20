package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

/**
 * Created by Alejandro on 4/16/2017.
 */

public abstract class DynamicPaymentActivity extends TransactionActivity {

    //TODO Se debe implementar para armar el formulario en base a los campos que indique el host

    protected int paymentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getPaymentView());
        getSupportActionBar().setTitle(getPaymentTitle());

        findViewById(R.id.btn_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPaymentType();
            }
        });
    }

    @Override
    protected void onPaymentTypeSelectResult(int status, Bundle data) {
        super.onPaymentTypeSelectResult(status, data);

        paymentType = data.getInt(GlobalConstants.EXTRA_PAYMENT_TYPE);

        switch (paymentType) {
            case GlobalConstants.PAYMENT_TYPE_CASH:
                requestUserCard();
                break;
            case GlobalConstants.PAYMENT_TYPE_ACCOUNT:
                requestCustomerCI();
                break;
        }
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        super.onUserCardRequestResult(status, data);
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        super.onUserPinRequestResult(status, data);

        Bundle request = buildPaymentRequest();
        sendHostRequest(request);
    }

    @Override
    protected void onCustomerCIRequestResult(int status, Bundle extras) {
        super.onCustomerCIRequestResult(status, extras);
        selectAccountType();
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);
        requestCustomerCard();
    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        super.onCustomerCardRequestResult(status, data);
        requestCustomerPin();
    }

    @Override
    protected void onCustomerPinRequestResult(int status, Bundle data) {
        super.onCustomerPinRequestResult(status, data);

        Bundle request = buildPaymentRequest();
        sendHostRequest(request);
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);
        displayMessage();
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);

        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_OK));
        finish();
    }

    protected abstract String getPaymentTitle();

    protected abstract int getPaymentView();

    protected abstract Bundle buildPaymentRequest();

}