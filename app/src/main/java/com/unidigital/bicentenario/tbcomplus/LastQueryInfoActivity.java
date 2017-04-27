package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LastQueryInfoActivity extends TransactionActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_last_query_info;
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

    public void onPrint(View view) {
        sendHostRequest();
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_last_query);
    }
}