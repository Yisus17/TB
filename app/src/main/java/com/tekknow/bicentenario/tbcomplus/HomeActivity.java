package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class HomeActivity extends BaseActivity {

    protected static final int POS_REQUEST = 1;
    protected static final int TBCOM_REQUEST = 2;
    protected static final int OPERATION_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchPOS(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "POS");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_pos));
        startActivityForResult(intent, POS_REQUEST);
    }

    public void launchCNB(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "CNB");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_cnb));
        startActivityForResult(intent, TBCOM_REQUEST);
    }

    public void launchControl(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "CONTROL");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_control));
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
}