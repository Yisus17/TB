package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_home:
                onCancel();// Volver al home
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
