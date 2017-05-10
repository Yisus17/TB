package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;
import com.unidigital.bicentenario.tbcomplus.widget.IdEditText;
import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;


import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class WithdrawalActivity extends TransactionActivity {

    public final Double MAX_AMOUNT = 6000.00;
    public final Double MIN_AMOUNT = 340.22;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        selectAccountType();
    }

    @Override
    protected void onAccountTypeSelectResult(int status, Bundle data) {
        super.onAccountTypeSelectResult(status, data);

        if(status == STATUS_BACK){
            onReturn();
        }else{
            setContentLayout(R.layout.activity_withdrawal);

            FocusableButton executeWithdrawal = (FocusableButton) findViewById(R.id.btn_execute_withdrawal);

            executeWithdrawal.setAction(new ActionListener() {
                @Override
                public void onAction() {
                    AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);
                    amountEditText.setMinAmount(MIN_AMOUNT);
                    amountEditText.setMaxAmount(MAX_AMOUNT);
                    amountEditText.setCurrentContext(context);

                    IdEditText idEditText = (IdEditText) findViewById(R.id.input_id);
                    idEditText.setCurrentContext(context);

                    boolean validation=true;
                    if (!amountEditText.validate().isValid){
                        amountEditText.setError(amountEditText.validate().msg);
                        validation=false;
                    }
                    if (!idEditText.validate().isValid){
                        idEditText.setError(idEditText.validate().msg);
                        validation=false;
                    }
                    if (validation)
                        requestCustomerCard();
                }
            });
        }
    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        super.onCustomerCardRequestResult(status, data);
        requestCustomerPin();
    }

    @Override
    protected void onCustomerPinRequestResult(int status, Bundle data) {
        super.onCustomerPinRequestResult(status, data);
        sendHostRequest();
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        super.onHostRequestResult(status, data);
        displayMessage();
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        super.onDisplayMessageResult(status, data);
        onAccept();
    }

    @Override
    public void onReturn(View view) {
        selectAccountType();
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_withdrawal);
    }
}