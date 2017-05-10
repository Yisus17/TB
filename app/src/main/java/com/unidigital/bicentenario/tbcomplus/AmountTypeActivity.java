package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class AmountTypeActivity extends BaseActivity {

    public final Double MAX_AMOUNT = 200000.45;
    public final Double MIN_AMOUNT = 1000.00;
    public int amountType;
    AmountEditText amountEditText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        FocusableButton execute = (FocusableButton) findViewById(R.id.btn_accept);
        if (amountType==AMOUNT_TYPE_BALANCE){
            amountEditText= (AmountEditText) findViewById(R.id.input_amount);
            amountEditText.setMinAmount(MIN_AMOUNT);
            amountEditText.setMaxAmount(MAX_AMOUNT);
            amountEditText.setCurrentContext(context);
            amountEditText.setEnabled(false);
        }


        View.OnClickListener first_radio_listener = new View.OnClickListener(){
            public void onClick(View v) {
                amountEditText.setEnabled(true);
            }
        };

        View.OnClickListener second_radio_listener = new View.OnClickListener(){
            public void onClick(View v) {
                amountEditText.setEnabled(true);
            }
        };

        RadioButton rb = (RadioButton) findViewById(R.id.opt_other);
        rb.setOnClickListener(first_radio_listener);

        RadioButton rb2 = (RadioButton) findViewById(R.id.opt_partial);
        rb.setOnClickListener(second_radio_listener);

        RadioButton rb3 = (RadioButton) findViewById(R.id.opt_total);
        rb.setOnClickListener(second_radio_listener);

        execute.setAction(new ActionListener() {
            @Override
            public void onAction() {
                switch (amountType){
                    case AMOUNT_TYPE_BALANCE:
                        if(amountEditText.validate().isValid)
                            onAccept();
                        else
                            amountEditText.setError(amountEditText.validate().msg);
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