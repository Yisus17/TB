package com.unidigital.bicentenario.tbcomplus;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unidigital.bicentenario.tbcomplus.global.GlobalUtilities;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

public class ReverseActivity extends TransactionActivity {

    String sequenceNumber;


    protected static final int CHECK_SEQUENCE_NUMBER_HOST_REQUEST = 1;
    protected static final int REVERSE_HOST_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sequenceNumber = "";
    }

    @Override
    protected void onReverseInfoDataRequestResult(int status, Bundle data) {
        if(status == STATUS_OK){
            requestReverseSure();
        }

    }

    @Override
    protected void onReverseSureRequestResult(int status, Bundle data) {
        requestUserCard();
    }

    @Override
    protected void onUserCardRequestResult(int status, Bundle data) {
        requestUserPin();
    }

    @Override
    protected void onUserPinRequestResult(int status, Bundle data) {
        data.putInt(EXTRA_REQUEST_CODE, REVERSE_HOST_REQUEST);
        sendHostRequest(data);
    }

    @Override
    protected void onHostRequestResult(int status, Bundle data) {
        switch (data.getInt(EXTRA_REQUEST_CODE)) {
            case CHECK_SEQUENCE_NUMBER_HOST_REQUEST:
                data.putString(EXTRA_SEQUENCE_NUMBER, sequenceNumber);
                requestReverseInfoData(data);
                break;
            case REVERSE_HOST_REQUEST:
                displayMessage();
                break;
        }
    }

    @Override
    protected void onDisplayMessageResult(int status, Bundle data) {
        onAccept();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_reverse;
    }

    @Override
    protected String getBarTitle() {
        return getString(R.string.title_activity_reverse);
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
