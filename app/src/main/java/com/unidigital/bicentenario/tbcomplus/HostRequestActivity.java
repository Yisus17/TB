package com.unidigital.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.unidigital.bicentenario.tbcomplus.api.HostApiEndpoint;
import com.unidigital.bicentenario.tbcomplus.api.RestClient;
import com.unidigital.bicentenario.tbcomplus.api.pojo.DepositRequest;
import com.unidigital.bicentenario.tbcomplus.api.pojo.DepositResponse;
import com.unidigital.bicentenario.tbcomplus.api.pojo.LoginRequest;
import com.unidigital.bicentenario.tbcomplus.api.pojo.PhoneOperator;

import static com.unidigital.bicentenario.tbcomplus.global.GlobalConstants.*;

import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HostRequestActivity extends BaseActivity {

    protected static final String BASE_URL = "http://10.10.10.100:8080/quantum/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = new Intent();

        int actionId = getIntent().getIntExtra(EXTRA_HOST_REQUEST_ACTION, 0);

        if (actionId > 0) {
            Parcelable requestData = getIntent().getParcelableExtra(EXTRA_HOST_REQUEST_DATA);
            HostApiEndpoint api = RestClient.getInstance().getApi(); //Retrofit Singleton
            Call call = getCall(api, actionId, requestData);

            call.enqueue(new Callback() {


                @Override
                public void onResponse(Call call, Response response) {

                    if (response.isSuccessful()) {
                        intent.putExtra(EXTRA_HOST_RESPONSE_DATA, (Parcelable) response.body());
                        intent.putExtra(EXTRA_STATUS, STATUS_OK);
                    } else {
                        intent.putExtra(EXTRA_STATUS, STATUS_ERROR);
                    }

                    setResult(RESULT_OK, intent);
                    finish();

                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    /*if(t instanceof SocketTimeoutException){
                        Log.i("PRUEBAS", "TIMEOUT");
                    }*/
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

    private Call getCall(HostApiEndpoint api, int action, Parcelable data) {
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