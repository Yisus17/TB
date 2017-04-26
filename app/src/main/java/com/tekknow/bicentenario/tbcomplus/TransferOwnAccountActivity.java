package com.tekknow.bicentenario.tbcomplus;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tekknow.bicentenario.tbcomplus.fragment.CiFragment;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class TransferOwnAccountActivity extends TransactionActivity {

    protected static final int TRANSFER_OWN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

            /*Button acceptData = (Button) findViewById(R.id.);

            CiFragment ciFragment = new CiFragment();

            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.ci_container, ciFragment, "ciFragment");
            transaction.commit();*/
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
    public void onAccept(View view) {
        requestCustomerCard();
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_transfer_own_account);
    }
}