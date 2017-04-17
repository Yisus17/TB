package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

/**
 * Created by Alejandro on 4/16/2017.
 */

public abstract class InternalPaymentActivity extends BaseActivity {

    protected static final int INQUIRY_HOST_REQUEST = 1;
    protected static final int PAYMENT_HOST_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getPaymentView());
        getSupportActionBar().setTitle(getPaymentTitle());

        findViewById(R.id.btn_execute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = buildPaymentInquiry(); //Obtener el objeto y enviarlo al sendHostRequest
                sendHostRequest();
            }
        });
    }

    @Override
    protected void onAmountTypeSelectResult(int status, Bundle data) {
        super.onAmountTypeSelectResult(status, data);
        selectPaymentType();
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);

        switch (data.getInt(GlobalConstants.EXTRA_REQUEST_CODE)) {
            case INQUIRY_HOST_REQUEST:
                selectAmountType();
                break;
            case PAYMENT_HOST_REQUEST:
        }
    }

    @Override
    protected void onPaymentTypeSelectResult(int status, Bundle data) {
        super.onPaymentTypeSelectResult(status, data);
        //TODO AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
    }

    protected abstract String getPaymentTitle();

    protected abstract int getPaymentView();

    protected abstract String buildPaymentInquiry(); //FIXME Construir un objeto que contenga URN, metodo, JSON, etc.

}