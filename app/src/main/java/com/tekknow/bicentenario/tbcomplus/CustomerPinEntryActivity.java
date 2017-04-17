package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class CustomerPinEntryActivity extends AppCompatActivity {

    Intent result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pin_entry);

        TextView textView = (TextView) findViewById(R.id.txt_pin_entry);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            setResult(RESULT_OK, new Intent());
            finish();
            }
        });
    }

    public void cancel(View view){
        setResult(RESULT_OK, new Intent().putExtra(GlobalConstants.EXTRA_STATUS, GlobalConstants.STATUS_CANCEL));
        finish();
    }

    @Override
    public void onBackPressed() {}
}
