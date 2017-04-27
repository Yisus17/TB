package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class TransferThirdActivity extends TransactionActivity {

    protected static final int TRANSFER_THIRD_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectOriginAccount();
    }

    @Override
    protected void onOriginAccountRequestResult(int status, Bundle data) {
        super.onTransferTypeRequestResult(status, data);

        if(status == STATUS_BACK){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "TRANSFERENCIAS");
            intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, "Transferencias");
            startActivityForResult(intent, TRANSFER_THIRD_REQUEST);
        }else {
            setContentLayout(R.layout.fragment_transfer_third_data);
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
        selectOriginAccount();
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    public void onAccept(View view) {
        requestCustomerCard();
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_transfer_third);
    }
}
