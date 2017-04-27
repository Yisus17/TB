package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class SaleActivity extends TransactionActivity {

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
        if(status == STATUS_BACK){
            onReturn();
        }else{
            requestCustomerEmail();
        }
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
                case CARD_TDD: //DEBITO
                    Bundle request = new Bundle();
                    request.putInt(EXTRA_ACCOUNT_MODE, ACCOUNT_MODE_CANCEL);
                    selectAccountType(request);
                    break;
                case CARD_TDC: //CREDITO
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

        switch (cardType){
            case CARD_TDD: //DEBITO
                requestCustomerPin();
                break;
            case CARD_TDC: //CREDITO
                sendHostRequest();
                break;
        }
    }

    @Override
    protected void onCustomerPinRequestResult(int status, Bundle data) {
        super.onCustomerPinRequestResult(status, data);
        sendHostRequest();
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);

        switch (cardType) {
            case CARD_TDD:
                displayMessage();
                break;
            case CARD_TDC:
                requestSignature();
                break;
        }
    }

    @Override
    protected void onSignatureRequestResult(int status, Bundle data) {
        super.onSignatureRequestResult(status, data);
        displayMessage();
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);
        onAccept();
    }


    @Override
    public void onReturn(View view) {
        if (cardType == CARD_TDD) {
            selectAccountType();
        } else {
            onCancel();
        }
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_sale);
    }
}