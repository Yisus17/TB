package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;


public class MainActivity extends BaseActivity {

    private static final int LOGIN_REQUEST = 1;
    private static final int HOME_REQUEST = 2;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST);
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        if(status == STATUS_OK){
            intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivityForResult(intent, HOME_REQUEST);
        }else{
            finish();
        }
    }
}