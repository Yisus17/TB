package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class HomeActivity extends BaseActivity {

    protected static final int POS_REQUEST = 1;
    protected static final int TBCOM_REQUEST = 2;
    protected static final int OPERATION_REQUEST = 3;


    public void launchPOS(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, CATEGORY_POS);
        intent.putExtra(EXTRA_TITLE, getString(R.string.category_pos));
        startActivityForResult(intent, POS_REQUEST);
    }

    public void launchCNB(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, CATEGORY_CNB);
        intent.putExtra(EXTRA_TITLE, getString(R.string.category_cnb));
        startActivityForResult(intent, TBCOM_REQUEST);
    }

    public void launchControl(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, CATEGORY_CONTROL);
        intent.putExtra(EXTRA_TITLE, getString(R.string.title_activity_operation_control));
        startActivityForResult(intent, OPERATION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        if(status == STATUS_CLOSE){
            setResult(RESULT_OK, new Intent().putExtra(EXTRA_STATUS, status));
            finish();
        }
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
        return R.layout.activity_home;
    }

    @Override
    public void onBackPressed() {
        onCancel();
    }
}