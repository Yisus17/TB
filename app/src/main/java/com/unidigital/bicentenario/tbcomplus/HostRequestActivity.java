package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.unidigital.bicentenario.tbcomplus.api.HostApiEndpoint;
import com.unidigital.bicentenario.tbcomplus.model.DepositRequest;
import com.unidigital.bicentenario.tbcomplus.model.HostRequest;
import com.unidigital.bicentenario.tbcomplus.model.HostResponse;
import com.unidigital.bicentenario.tbcomplus.model.LoginRequest;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HostRequestActivity extends BaseActivity {

    protected static final String BASE_URL = "http://10.0.2.2:8080/quantum/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = new Intent();

        int action = getIntent().getIntExtra(EXTRA_HOST_REQUEST_ACTION, 0);

        if (action > 0) {
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            HostApiEndpoint api = retrofit.create(HostApiEndpoint.class);
            Serializable requestData = getIntent().getSerializableExtra(EXTRA_HOST_REQUEST_DATA);

            Call call = getCall(api, action, requestData);

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Log.d("TBComPlus", response.body().toString());
                    intent.putExtra(EXTRA_HOST_RESPONSE_DATA, (Serializable) response.body());
                    intent.putExtra(EXTRA_STATUS, STATUS_OK);
                    setResult(RESULT_OK, intent);
                    finish();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e("TBComPlus", "ERROR", t);

                    intent.putExtra(EXTRA_STATUS, STATUS_ERROR);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }else{
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                public void run() {
                    onAccept();
                }
            }, new Random().nextInt(2000) + 500);
        }

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
        return R.layout.activity_host_request;
    }

    private Call getCall(HostApiEndpoint api, int action, Serializable data) {
        switch (action) {
            case HOST_ACTION_LOGIN:
                return api.login((LoginRequest) data);
            case HOST_ACTION_DEPOSIT:
                return api.deposit((DepositRequest) data);
            default:
                return null;
        }
    }

}