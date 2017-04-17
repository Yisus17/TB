package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean cancelled = data.getIntExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_OK) == GlobalConstants.STATUS_CANCEL; // 0: se continua con el flujo, 1: se canceló la acción

        if (cancelled) { //Cierra la aplicacion
            finish();
        } else { //Ingresa al menu principal
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
    }
}