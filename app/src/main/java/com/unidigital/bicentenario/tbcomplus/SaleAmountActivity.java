package com.unidigital.bicentenario.tbcomplus;


import android.content.Context;
import android.os.Bundle;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;

public class SaleAmountActivity extends BaseActivity {

    public final Double MAX_AMOUNT = 70000.00;
    public final Double MIN_AMOUNT = 3000.00;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        FocusableButton executeSaleAmount = (FocusableButton) findViewById(R.id.btn_execute);

        executeSaleAmount.setAction(new ActionListener() {
            @Override
            public void onAction() {
                AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);

                amountEditText.setMinAmount(MIN_AMOUNT);
                amountEditText.setMaxAmount(MAX_AMOUNT);
                amountEditText.setCurrentContext(context);

                if(amountEditText.validate())
                    onAccept();

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sale_amount;
    }
}
