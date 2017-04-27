package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class UserCardReadActivity extends BaseActivity {

    int modality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = (TextView) findViewById(R.id.txt_card_read);

        modality = getIntent().getIntExtra(EXTRA_MODALITY, MODALITY_AUTHENTICATE_OPERATIONS);

        switch (modality) {
            case MODALITY_START_OPERATIONS:
                textView.setText(R.string.action_card_start_user_read);
                break;
            case MODALITY_REOPEN_OPERATIONS:
                textView.setText(R.string.action_card_reopen_user_read);
                break;
            default:
                textView.setText(R.string.action_card_user_read);
                break;
        }

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
        return R.layout.activity_user_card_read;
    }

}