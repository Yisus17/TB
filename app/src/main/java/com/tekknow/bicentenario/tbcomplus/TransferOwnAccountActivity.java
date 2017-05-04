package com.tekknow.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tekknow.bicentenario.tbcomplus.interfaces.ActionListener;
import com.tekknow.bicentenario.tbcomplus.widget.AccountEditText;
import com.tekknow.bicentenario.tbcomplus.widget.AmountEditText;
import com.tekknow.bicentenario.tbcomplus.widget.FocusableButton;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class TransferOwnAccountActivity extends TransactionActivity {

    protected static final int TRANSFER_OWN_REQUEST = 1;
    public final Double MAX_AMOUNT = 200000.45;
    public final Double MIN_AMOUNT = 1040.32;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        selectTransferType();
    }

    @Override
    protected void onTransferTypeRequestResult(int status, Bundle data) {
        super.onTransferTypeRequestResult(status, data);

        if(status == STATUS_BACK){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "TRANSFERENCIAS");
            intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, "Transferencias");
            startActivityForResult(intent, TRANSFER_OWN_REQUEST);
        }else{
            setContentLayout(R.layout.fragment_transfer_amount);

            FocusableButton execute = (FocusableButton) findViewById(R.id.btn_execute);

            execute.setAction(new ActionListener() {
                @Override
                public void onAction() {
                    AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);

                    amountEditText.setMinAmount(MIN_AMOUNT);
                    amountEditText.setMaxAmount(MAX_AMOUNT);
                    amountEditText.setCurrentContext(context);

                    if(amountEditText.validate())
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
        selectTransferType();
    }

    @Override
    protected int getLayout() {
        return -1;
    }


    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_transfer_own_account);
    }
}