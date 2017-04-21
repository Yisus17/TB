package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;


public class MainActivity extends BaseActivity {

    private static final int LOGIN_REQUEST = 1;
    private static final int HOME_REQUEST = 2;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        switch (status) {
            case STATUS_CANCEL:
                finish();
                break;
            case STATUS_CLOSE:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, LOGIN_REQUEST);
                break;
            default:
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivityForResult(intent, HOME_REQUEST);
        }
    }
}