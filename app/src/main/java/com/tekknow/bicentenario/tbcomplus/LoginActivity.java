package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;


public class LoginActivity extends BaseActivity {

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

        if(status == GlobalConstants.STATUS_CANCEL){
            cancel();
        }else{
            sendHostRequest();
        }
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);

        Bundle extras = new Bundle();
        extras.putInt(GlobalConstants.EXTRA_MESSAGE_TYPE, GlobalConstants.MESSAGE_TYPE_SUCCESS);
        extras.putString(GlobalConstants.EXTRA_MESSAGE_CONTENT, getString(R.string.msg_success_login));

        displayMessage(extras);
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);

        setResult(RESULT_OK, new Intent());
        finish();
    }

    public void cancel(){
        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_CANCEL));
        finish();
    }

}