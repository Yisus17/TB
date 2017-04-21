package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class UserPinEntryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pin_entry);

        TextView textView = (TextView) findViewById(R.id.txt_pin_entry);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            onAccept();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

}