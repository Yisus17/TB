package com.tekknow.bicentenario.tbcomplus;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.tekknow.bicentenario.tbcomplus.model.SignatureView;

public class SignatureCaptureActivity extends BaseActivity {

    SignatureView signatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout signaturePad = (LinearLayout) findViewById(R.id.signature_pad);

        signatureView = new SignatureView(this);

        signaturePad.addView(signatureView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_signature_capture;
    }

    public void onClear(View view) {
        signatureView.clear();
    }
}