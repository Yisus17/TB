package com.tekknow.bicentenario.tbcomplus;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public abstract class OperationControlActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getOperationClosureView());
    }

    @Override
    public void onAccept(View view) {
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

        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, getOperationStatus()));
        finish();
    }

    protected abstract String getOperationClosureTitle();

    protected abstract int getOperationClosureView();

    protected abstract int getOperationStatus();
}
