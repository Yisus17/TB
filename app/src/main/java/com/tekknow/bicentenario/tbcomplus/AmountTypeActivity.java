package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;
import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class AmountTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int amountType = getIntent().getIntExtra(EXTRA_AMOUNT_TYPE, AMOUNT_TYPE_BALANCE);

        switch (amountType) {
            case AMOUNT_TYPE_FIXED:
                setContentView(R.layout.activity_amount_type_fixed);
                break;
            case AMOUNT_TYPE_BALANCE:
                setContentView(R.layout.activity_amount_type_balance);
                break;
        }
    }
}