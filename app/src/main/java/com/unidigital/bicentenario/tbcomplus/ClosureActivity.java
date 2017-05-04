package com.unidigital.bicentenario.tbcomplus;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public abstract class ClosureActivity extends TransactionActivity {


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

        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, getOperationStatus()));
        finish();
    }

    protected abstract String getOperationClosureTitle();

    protected abstract int getOperationClosureView();

    protected abstract int getOperationStatus();

    @Override
    protected String getBarTitle() {
        return getOperationClosureTitle();
    }

    @Override
    protected int getLayout() {
        return getOperationClosureView();
    }
}
