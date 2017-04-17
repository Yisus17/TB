package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClosePosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_pos);
        getSupportActionBar().setTitle(getString(R.string.title_activity_close_pos));
    }

    public void acceptClose(View view) {
        sendHostRequest();
    }

    public void declineClose(View view) {
        finish();
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

}