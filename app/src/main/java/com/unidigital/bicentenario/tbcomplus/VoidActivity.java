package com.unidigital.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

/**
 * Created by Mercedes Rodriguez on 5/3/2017.
 */

public class VoidActivity extends TransactionActivity {

    String sequenceNumber;

    protected static final int CHECK_USER_REQUEST = 1;
    protected static final int CHECK_SEQUENCE_NUMBER_HOST_REQUEST = 2;
    protected static final int REVERSE_HOST_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sequenceNumber = "";

        requestUserCard();
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        data.putInt(EXTRA_REQUEST_CODE, CHECK_USER_REQUEST);
        sendHostRequest(data);
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        switch (data.getInt(EXTRA_REQUEST_CODE)) {
            case CHECK_USER_REQUEST:
                setContentLayout(R.layout.activity_void);
                break;
            case CHECK_SEQUENCE_NUMBER_HOST_REQUEST:
                data.putString(EXTRA_SEQUENCE_NUMBER, sequenceNumber);
                requestVoidInfoData(data);
                break;
            case REVERSE_HOST_REQUEST:
                displayMessage();
                break;
        }
    }

    @Override
    protected void onVoidInfoDataRequestResult(int status, Bundle data) {
        if(status == STATUS_OK){
            requestVoidSure();
        }
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        onAccept();
    }

    @Override
    protected void onVoidSureRequestResult(int status, Bundle data) {
        requestCustomerCard();
    }

    @Override
    protected void onCustomerCardRequestResult(int status, Bundle data) {
        requestCustomerPin();
    }

    @Override
    protected void onCustomerPinRequestResult(int status, Bundle data) {
        if(data == null)
            data = new Bundle();

        data.putInt(EXTRA_REQUEST_CODE, REVERSE_HOST_REQUEST);
        sendHostRequest(data);
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_void);
    }

    public void onAcceptSequenceNumber(View view) {
        Toast alertToast;

        EditText inputSequenceNumber = (EditText) findViewById(R.id.input_sequence_number);
        sequenceNumber = inputSequenceNumber.getText().toString();

        if(sequenceNumber.trim().length() == 0){
            GlobalUtilities.displayMessage(getString(R.string.no_empty_sequence_number), this, MESSAGE_ERROR);
        }else{
            Bundle request = new Bundle();
            request.putInt(EXTRA_REQUEST_CODE, CHECK_SEQUENCE_NUMBER_HOST_REQUEST);
            sendHostRequest(request);
        }
    }
}
