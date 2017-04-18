package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class CustomerCardReadActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_card_read);

        //FIXME Prototipo
        TextView textView = (TextView) findViewById(R.id.txt_card_read);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
    }
}