package com.unidigital.bicentenario.tbcomplus;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class AmountTypeActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        int amountType = getIntent().getIntExtra(EXTRA_AMOUNT_TYPE, AMOUNT_TYPE_BALANCE);

        if(amountType == AMOUNT_TYPE_FIXED){
            return R.layout.activity_amount_type_fixed;
        }else{
            return R.layout.activity_amount_type_balance;
        }
    }
}