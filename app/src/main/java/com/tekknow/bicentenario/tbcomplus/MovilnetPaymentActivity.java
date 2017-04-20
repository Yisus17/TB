package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;

/**
 * Created by Alejandro on 4/16/2017.
 */

public class MovilnetPaymentActivity extends PaymentActivity {

    @Override
    protected String getPaymentTitle() {
        return getString(R.string.title_activity_movilnet_payment);
    }

    @Override
    protected int getPaymentView() {
        return R.layout.activity_phone_payment;
    }

    @Override
    protected Bundle buildInquiryRequest() {
        return new Bundle();
    }

    @Override
    protected Bundle buildPaymentRequest() {
        return new Bundle();
    }

}