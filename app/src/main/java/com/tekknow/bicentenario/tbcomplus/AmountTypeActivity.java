package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.global.GlobalConstants;

public class AmountTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int amountType = getIntent().getIntExtra(GlobalConstants.EXTRA_AMOUNT_TYPE, GlobalConstants.AMOUNT_TYPE_BALANCE);

        switch (amountType) {
            case GlobalConstants.AMOUNT_TYPE_FIXED:
                setContentView(R.layout.activity_amount_type_fixed);
                break;
            case GlobalConstants.AMOUNT_TYPE_BALANCE:
                setContentView(R.layout.activity_amount_type_balance);
                break;
        }
    }

    public void accept(View view) {
        //TODO Colocar el monto a pagar en el result
        setResult(RESULT_OK, new Intent());
        finish();
    }

}