package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

//TODO Hacer manejo de diferentes tipos de mensaje (exito, info, error, warning)

public class DisplayMessageActivity extends GenericActivity {

    int requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_success_message);

        requestCode = getIntent().getIntExtra(GlobalConstants.EXTRA_REQUEST_CODE, 0);

        String message = getIntent().hasExtra(GlobalConstants.EXTRA_MESSAGE_CONTENT) ? getIntent().getStringExtra(GlobalConstants.EXTRA_MESSAGE_CONTENT) : getString(R.string.msg_success_transaction);

        TextView txt_message = (TextView) findViewById(R.id.txt_message);
        txt_message.setText(message);
    }

    @Override
    public void onAccept(View view) {
        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_REQUEST_CODE, requestCode));
        finish();
    }
}