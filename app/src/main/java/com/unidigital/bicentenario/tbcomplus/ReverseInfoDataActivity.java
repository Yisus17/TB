package com.tekknow.bicentenario.tbcomplus;


import android.os.Bundle;
import android.widget.TextView;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;

public class ReverseInfoDataActivity extends BaseActivity {

    String txtSequenceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent()!= null && getIntent().getStringExtra(EXTRA_SEQUENCE_NUMBER) != null){
            txtSequenceNumber = getIntent().getStringExtra(EXTRA_SEQUENCE_NUMBER);
        }else{
            txtSequenceNumber = "";
        }

        TextView sequenceNumber = (TextView) findViewById(R.id.txt_sequence_number);
        sequenceNumber.setText(txtSequenceNumber);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_reverse_info_data;
    }
}
