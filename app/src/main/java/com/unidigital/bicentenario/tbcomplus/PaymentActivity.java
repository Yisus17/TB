package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

/**
 * Created by Alejandro on 4/16/2017.
 */

public abstract class PaymentActivity extends TransactionActivity {

    protected static final int INQUIRY_HOST_REQUEST = 1;
    protected static final int PAYMENT_HOST_REQUEST = 2;

    protected int paymentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle request = buildInquiryRequest();
                request.putInt(EXTRA_REQUEST_CODE, INQUIRY_HOST_REQUEST);
                sendHostRequest(request);
            }
        });
    }

    @Override
    protected void onAmountTypeSelectResult(int status, Bundle data) {
        super.onAmountTypeSelectResult(status, data);
        if(status == STATUS_OK){
            selectPaymentType();
        }
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);

        switch (data.getInt(EXTRA_REQUEST_CODE)) {
            case INQUIRY_HOST_REQUEST:
                selectAmountType();
                break;
            case PAYMENT_HOST_REQUEST:
                displayMessage();
                break;
        }
    }

    @Override
    protected void onPaymentTypeSelectResult(int status, Bundle data) {
        super.onPaymentTypeSelectResult(status, data);

        if(status == STATUS_BACK){
            selectAmountType();
        }else{
            paymentType = data.getInt(EXTRA_PAYMENT_TYPE);

            switch (paymentType) {
                case PAYMENT_TYPE_CASH:
                    requestUserCard();
                    break;
                case PAYMENT_TYPE_ACCOUNT:
                    requestCustomerCI();
                    break;
            }
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
        request.putInt(EXTRA_REQUEST_CODE, PAYMENT_HOST_REQUEST);
        sendHostRequest(request);
    }

    @Override
    protected void onCustomerCIRequestResult(int status, Bundle extras) {
        super.onCustomerCIRequestResult(status, extras);
        if(status == STATUS_BACK){
            selectPaymentType();
        }else{
            selectAccountType();
        }
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);

        if(status == STATUS_BACK){
            requestCustomerCI();
        }else{
            requestCustomerCard();
        }
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
        request.putInt(EXTRA_REQUEST_CODE, PAYMENT_HOST_REQUEST);
        sendHostRequest(request);
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);
        onAccept();
    }

    protected abstract String getPaymentTitle();

    protected abstract int getPaymentView();

    protected abstract Bundle buildInquiryRequest();

    protected abstract Bundle buildPaymentRequest();

    @Override
    protected String getBarTitle() {
        return getPaymentTitle();
    }
}