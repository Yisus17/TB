package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

//TODO Hacer manejo de diferentes tipos de mensaje (exito, info, error, warning)

public class DisplayMessageActivity extends BaseActivity {

    int requestCode;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestCode = getIntent().getIntExtra(EXTRA_REQUEST_CODE, 0);
        message = getIntent().hasExtra(EXTRA_MESSAGE_CONTENT) ? getIntent().getStringExtra(EXTRA_MESSAGE_CONTENT) : getString(R.string.msg_success_transaction);

        TextView txt_message = (TextView) findViewById(R.id.txt_message);
        txt_message.setText(message);
    }

    @Override
    public void onAccept(View view) {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_REQUEST_CODE, requestCode));
        finish();
    }

    @Override
    public void onBackPressed() {}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    protected int getLayout() {
        return R.layout.activity_success_message;
    }
}