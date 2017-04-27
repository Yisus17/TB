package com.unidigital.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class UserPinEntryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    protected int getLayout() {
        return R.layout.activity_user_pin_entry;
    }

}