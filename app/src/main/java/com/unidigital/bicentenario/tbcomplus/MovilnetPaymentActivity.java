package com.unidigital.bicentenario.tbcomplus;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;

import com.unidigital.bicentenario.tbcomplus.widget.PhoneEditText;

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

    @Override
    protected int getLayout() {
        return getPaymentView();
    }

    @Override
    protected boolean onValidate() {
        final PhoneEditText PhoneEditText = (PhoneEditText) findViewById(R.id.input_phone);
        PhoneEditText.setCurrentContext(this);
        PhoneEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        return (PhoneEditText.validate());
    }
}