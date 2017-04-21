package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

/**
 * Created by Alejandro on 4/16/2017.
 */

public class MovilnetRechargeActivity extends PaymentActivity {

    @Override
    protected String getPaymentTitle() {
        return getString(R.string.title_activity_movilnet_recharge);
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
    protected void onHostRequestResult(int status, Bundle data) { //FIXME Esto esta forzado para efectos del prototipo (para que muestre montos fijos)
        switch (data.getInt(EXTRA_REQUEST_CODE)) {
            case INQUIRY_HOST_REQUEST:
                Bundle request = new Bundle();
                request.putInt(EXTRA_AMOUNT_TYPE, AMOUNT_TYPE_FIXED);
                selectAmountType(request);
                break;
            case PAYMENT_HOST_REQUEST:
                displayMessage();
                break;
        }
    }

}