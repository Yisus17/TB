package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;


public class LoginActivity extends TransactionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestUserCard();
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        super.onUserCardRequestResult(status, data);
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        super.onUserPinRequestResult(status, data);

        if(status == STATUS_CANCEL){
            cancel();
        }else{
            sendHostRequest();
        }
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);

        Bundle extras = new Bundle();
        extras.putInt(EXTRA_MESSAGE_TYPE, MESSAGE_TYPE_SUCCESS);

        displayMessage(extras);
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);

        setResult(RESULT_OK, new Intent());
        finish();
    }

    public void cancel(){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CANCEL));
        finish();
    }

}