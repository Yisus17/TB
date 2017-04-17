package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchPOS(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "POS");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_pos));
        startActivity(intent);
    }

    public void launchCNB(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "CNB");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_cnb));
        startActivity(intent);
    }

    public void launchControl(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "CONTROL");
        intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, getString(R.string.category_control));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}

}