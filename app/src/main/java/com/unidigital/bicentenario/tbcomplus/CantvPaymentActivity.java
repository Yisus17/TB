package com.unidigital.bicentenario.tbcomplus;

import android.os.Bundle;

/**
 * Created by Alejandro on 4/16/2017.
 */

public class CantvPaymentActivity extends PaymentActivity {

    @Override
    protected String getPaymentTitle() {
        return getString(R.string.title_activity_cantv_payment);
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

    @Override
    protected int getLayout() {
       return getPaymentView();
    }
}