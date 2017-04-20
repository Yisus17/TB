package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class UserCardReadActivity extends BaseActivity {

    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_card_read);

        TextView textView = (TextView) findViewById(R.id.txt_card_read);

        message = getIntent().hasExtra(EXTRA_MESSAGE_CONTENT) ? getIntent().getStringExtra(EXTRA_MESSAGE_CONTENT) : getString(R.string.action_card_cnb_read);
        textView.setText(message);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            setResult(RESULT_OK, new Intent());
            finish();
            }
        });
    }
}