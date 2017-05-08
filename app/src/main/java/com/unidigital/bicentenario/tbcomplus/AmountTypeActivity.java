package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.os.Bundle;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class AmountTypeActivity extends BaseActivity {

    public final Double MAX_AMOUNT = 200000.45;
    public final Double MIN_AMOUNT = 1000.00;

    public int amountType;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        FocusableButton execute = (FocusableButton) findViewById(R.id.btn_accept);

        execute.setAction(new ActionListener() {
            @Override
            public void onAction() {
                switch (amountType){
                    case AMOUNT_TYPE_BALANCE:
                        AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);

                        amountEditText.setMinAmount(MIN_AMOUNT);
                        amountEditText.setMaxAmount(MAX_AMOUNT);
                        amountEditText.setCurrentContext(context);

                        if(amountEditText.validate())
                            onAccept();
                        break;
                    default:
                        onAccept();
                        break;
                }
            }
        });
    }

    @Override
    protected int getLayout() {
        amountType = getIntent().getIntExtra(EXTRA_AMOUNT_TYPE, AMOUNT_TYPE_BALANCE);

        if(amountType == AMOUNT_TYPE_FIXED){
            return R.layout.activity_amount_type_fixed;
        }else{
            return R.layout.activity_amount_type_balance;
        }
    }
}