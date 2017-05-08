package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;
import com.unidigital.bicentenario.tbcomplus.widget.IdEditText;
import com.unidigital.bicentenario.tbcomplus.widget.PhoneEditText;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.EXTRA_REQUEST_CODE;

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

    @Override
    protected boolean onValidate() {
        final PhoneEditText PhoneEditText = (PhoneEditText) findViewById(R.id.input_phone);
        PhoneEditText.setCurrentContext(this);
        PhoneEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        return (PhoneEditText.validate());
    }
}