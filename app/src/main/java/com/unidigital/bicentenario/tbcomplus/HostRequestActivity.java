package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

import java.util.Random;

public class HostRequestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int requestCode = getIntent().getIntExtra(EXTRA_REQUEST_CODE, 0);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                setResult(RESULT_OK, new Intent().putExtra(EXTRA_REQUEST_CODE, requestCode)); //TODO Agregar respuesta del host
                finish();
            }
        }, new Random().nextInt(2000) + 500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_host_request;
    }

}