package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class BaseActivity extends AppCompatActivity {

    public void onAccept() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_OK));
        finish();
    }

    public void onReturn() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_BACK));
        finish();
    }

    public void onCancel() {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CANCEL));
        finish();
    }

    public void onClose(){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, STATUS_CLOSE));
        finish();
    }

    public void onAccept(View view) {
        onAccept();
    }

    public void onReturn(View view){
        onReturn();
    }

    public void onCancel(View view){
        onCancel();
    }

    @Override
    public void onBackPressed() {}
}
