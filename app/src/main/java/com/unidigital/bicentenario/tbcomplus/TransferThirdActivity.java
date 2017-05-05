package com.unidigital.bicentenario.tbcomplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.unidigital.bicentenario.tbcomplus.interfaces.ActionListener;
import com.unidigital.bicentenario.tbcomplus.widget.AccountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.AmountEditText;
import com.unidigital.bicentenario.tbcomplus.widget.FocusableButton;
import com.unidigital.bicentenario.tbcomplus.widget.IdEditText;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class TransferThirdActivity extends TransactionActivity {

    protected static final int TRANSFER_THIRD_REQUEST = 1;
    public final Double MAX_AMOUNT = 200000.45;
    public final Double MIN_AMOUNT = 1040.32;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        selectOriginAccount();
    }

    @Override
    protected void onOriginAccountRequestResult(int status, Bundle data) {
        super.onTransferTypeRequestResult(status, data);

        if(status == STATUS_BACK){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra(MenuActivity.MENU_CATEGORY_ID, "TRANSFERENCIAS");
            intent.putExtra(MenuActivity.MENU_CATEGORY_TITLE, "Transferencias");
            startActivityForResult(intent, TRANSFER_THIRD_REQUEST);
        }else {
            setContentLayout(R.layout.fragment_transfer_third_data);

            FocusableButton execute = (FocusableButton) findViewById(R.id.btn_execute);

            execute.setAction(new ActionListener() {
                @Override
                public void onAction() {
                    AmountEditText amountEditText = (AmountEditText) findViewById(R.id.input_amount);
                    amountEditText.setMinAmount(MIN_AMOUNT);
                    amountEditText.setMaxAmount(MAX_AMOUNT);
                    amountEditText.setCurrentContext(context);

                    AccountEditText accountEditText= (AccountEditText) findViewById(R.id.input_account);
                    accountEditText.setCurrentContext(context);

                    IdEditText idEditText = (IdEditText) findViewById(R.id.input_id);
                    idEditText.setCurrentContext(context);

                    if(amountEditText.validate() && accountEditText.validate() && idEditText.validate())
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
        selectOriginAccount();
    }

    @Override
    protected int getLayout() {
        return -1;
    }


    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_transfer_third);
    }
}
