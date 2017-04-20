package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class TransferOwnAccountActivity extends TransactionActivity {

    protected static final int TRANSFER_OWN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectTransferType();
    }

    @Override
    protected void onTransferTypeRequestResult(int status, Bundle data) {
        super.onTransferTypeRequestResult(status, data);

        if(status == STATUS_BACK){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "TRANSFERENCIAS");
            intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, "Transferencias");
            startActivityForResult(intent, TRANSFER_OWN_REQUEST);
        }else{
            setContentView(R.layout.fragment_transfer_amount);
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
        onAccept();
    }

    @Override
    public void onReturn(View view) {
        selectTransferType();
    }

    @Override
    public void onAccept(View view) {
        requestCustomerCard();
    }

}