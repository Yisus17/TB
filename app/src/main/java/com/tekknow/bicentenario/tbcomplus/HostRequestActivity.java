package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

import java.util.Random;

public class HostRequestActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_host_request);

        final int requestCode = getIntent().getIntExtra(GlobalConstants.EXTRA_REQUEST_CODE, 0);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_REQUEST_CODE, requestCode)); //TODO Agregar respuesta del host
                finish();
            }
        }, new Random().nextInt(2000) + 500);
    }

}