package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class InfoQueryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_query);
        getSupportActionBar().setTitle(getString(R.string.title_activity_deposit));
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

    public void execute(View view) {
        sendHostRequest();
    }
}