package com.tekknow.bicentenario.tbcomplus;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class SaleActivity extends BaseActivity {

    protected int cardType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardType = -1;
        requestCustomerCard();
    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        super.onCustomerCardRequestResult(status, data);
        selectCardType();
    }

    @Override
    protected void onCardTypeSelectResult(int status, Bundle data) {
        super.onCardTypeSelectResult(status, data);

        if (data.containsKey(GlobalConstants.CARD_TYPE)) {
            cardType = data.getInt(GlobalConstants.CARD_TYPE);

            switch (cardType){
                case GlobalConstants.CARD_TYPE_1: //DEBITO
                    selectAccountType();
                    break;
                case GlobalConstants.CARD_TYPE_2: //CREDITO
                    setContentView(R.layout.activity_enter_customer_data);
                    break;
            }
        }
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);
        setContentView(R.layout.activity_enter_customer_data);
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
        if (cardType == GlobalConstants.CARD_TYPE_1) {
            selectAccountType();
        } else {
            setResult(RESULT_OK, new Intent());
            finish();
        }
    }

    public void execute(View view) {
        requestCustomerPin();
    }

}