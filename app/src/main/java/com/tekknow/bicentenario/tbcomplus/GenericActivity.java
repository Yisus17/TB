package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class GenericActivity extends AppCompatActivity {

    public void onAccept(View view) {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_OK));
        finish();
    }

    public void onReturn(View view){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_BACK));
        finish();
    }

    public void onCancel(View view){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CANCEL));
        finish();
    }

    @Override
    public void onBackPressed() {}
}
