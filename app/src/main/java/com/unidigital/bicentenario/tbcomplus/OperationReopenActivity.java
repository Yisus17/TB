package com.unidigital.bicentenario.tbcomplus;


import android.os.Bundle;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class OperationReopenActivity extends TransactionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = new Bundle();
        extras.putInt(EXTRA_MODALITY, MODALITY_REOPEN_OPERATIONS);

        requestUserCard(extras);
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        super.onUserCardRequestResult(status, data);
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        super.onUserPinRequestResult(status, data);
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
    protected String getBarTitle() {
        return getString(R.string.title_activity_operation_reopen);
    }
}
