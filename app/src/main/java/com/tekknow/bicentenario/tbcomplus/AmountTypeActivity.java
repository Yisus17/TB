package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AmountTypeActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_type);
    }

    public void accept(View view) {
        //TODO Colocar el monto a pagar en el result
        setResult(RESULT_OK, new Intent());
        finish();
    }

}