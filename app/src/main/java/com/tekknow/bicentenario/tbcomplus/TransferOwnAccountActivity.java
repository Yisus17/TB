package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class TransferOwnAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectTransferType();
    }

    @Override
    protected void onTransferTypeRequestResult(int status, Bundle data) {
        super.onTransferTypeRequestResult(status, data);
        setContentView(R.layout.fragment_transfer_amount);
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
        selectTransferType();
    }

    public void execute(View view) {
        requestCustomerCard();
    }

}