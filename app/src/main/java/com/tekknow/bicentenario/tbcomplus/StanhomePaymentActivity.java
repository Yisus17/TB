package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;

/**
 * Created by Alejandro on 4/16/2017.
 */

public class StanhomePaymentActivity extends DynamicPaymentActivity {

    @Override
    protected String getPaymentTitle() {
        return getString(R.string.title_activity_stanhome_payment);
    }

    @Override
    protected int getPaymentView() {
        return R.layout.activity_stanhome_payment;
    }

    @Override
    protected Bundle buildPaymentRequest() {
        return new Bundle();
    }

    @Override
    protected int getLayout() {
        return getPaymentView();
    }
}