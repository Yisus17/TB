package com.tekknow.bicentenario.tbcomplus;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class SaleActivity extends BaseActivity {

    protected int cardType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardType = -1;

        requestCustomerCI();
    }

    @Override
    protected void onCustomerCIRequestResult(int status, Bundle extras) {
        super.onCustomerCIRequestResult(status, extras);
        requestCustomerEmail();
    }

    @Override
    protected void onCustomerEmailRequestResult(int status, Bundle extras) {
        super.onCustomerEmailRequestResult(status, extras);

        if(status == STATUS_BACK){
            requestCustomerCI();
        }else{
            requestCustomerCard();
        }

    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        super.onCustomerCardRequestResult(status, data);
        selectCardType();
    }

    @Override
    protected void onCardTypeSelectResult(int status, Bundle data) {
        super.onCardTypeSelectResult(status, data);

        if (data.containsKey(CARD_TYPE)) {
            cardType = data.getInt(CARD_TYPE);

            switch (cardType){
                case CARD_TYPE_1: //DEBITO
                    selectAccountType();
                    break;
                case CARD_TYPE_2: //CREDITO
                    requestSaleAmount();
                    break;
            }
        }
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);
        requestSaleAmount();
    }

    @Override
    protected void onSaleAmountRequestResult(int status, Bundle extras) {
        super.onSaleAmountRequestResult(status, extras);
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
        if (cardType == CARD_TYPE_1) {
            selectAccountType();
        } else {
            setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CANCEL));
            finish();
        }
    }
}