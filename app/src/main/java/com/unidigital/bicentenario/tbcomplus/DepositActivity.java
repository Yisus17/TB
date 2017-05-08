package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.unidigital.bicentenario.tbcomplus.global.GlobalConstants;
import com.unidigital.bicentenario.tbcomplus.model.DepositRequest;

import java.math.BigDecimal;

public class DepositActivity extends TransactionActivity {

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

    public void onAccept(View view) {
        requestUserCard();
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