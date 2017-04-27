package com.tekknow.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.tekknow.bicentenario.tbcomplus.widget.AmountEditText;

public class DepositActivity extends TransactionActivity {

    public final Double MAX_AMOUNT = 5000.40;
    public final Double MIN_AMOUNT = 1040.32;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        Button executeDeposit = (Button) findViewById(R.id.btn_execute_deposit);

        executeDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AmountEditText editTextAmount = (AmountEditText) findViewById(R.id.input_amount);
                //editTextAmount.clearFocus();

                /*InputMethodManager im = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);*/

                //view.requestFocusFromTouch();

                boolean isValid = editTextAmount.isValidAmount(MIN_AMOUNT , MAX_AMOUNT);

                if(isValid){
                    requestUserCard();
                }else{
                    Toast toast = Toast.makeText(context, "Error" , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        super.onUserCardRequestResult(status, data);
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        super.onUserPinRequestResult(status, data);
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

        setResult(RESULT_OK, new Intent());
        finish();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_deposit;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_deposit);
    }
}