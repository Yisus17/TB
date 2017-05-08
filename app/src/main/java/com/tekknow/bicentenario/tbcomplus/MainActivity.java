package com.tekknow.bicentenario.tbcomplus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.gson.JsonObject;
import com.tekknow.bicentenario.tbcomplus.api.DepositItem;
import com.tekknow.bicentenario.tbcomplus.api.apiService;
import com.tekknow.bicentenario.tbcomplus.api_models.apiResponse;

import java.math.BigDecimal;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tekknow.bicentenario.tbcomplus.global.GlobalConstants.*;


public class MainActivity extends BaseActivity {

    private static final int LOGIN_REQUEST = 1;
    private static final int HOME_REQUEST = 2;

    private Retrofit retrofit;
    private static final String TAG= "API: ";

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        apiConn();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST);
    }

    public void apiConn() {
        retrofit= new Retrofit.Builder()
                .baseUrl("http://10.10.10.100:8080/quantum/")
                .addConverterFactory(GsonConverterFactory.create()) //Formateando a JSON los mensajes
                .build();
        getData();
    }

    private void getData() {
        apiService service = retrofit.create(apiService.class);

        //JSONOBJECT---------------------------------------------------------
         /*JsonObject obj = new JsonObject();
        obj.addProperty("account","123456");
        obj.addProperty("amount", BigDecimal.valueOf(250.00));

       Call<JsonObject> call = service.getDepositTest(obj);
        call.enqueue(new Callback<JsonObject>() {
             @Override
             public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                 Log.i(TAG,response.body().toString());
             }

             @Override
             public void onFailure(Call<JsonObject> call, Throwable t) {
                 Log.i(TAG,"Getting response from server : "+t);
             }
         }
        );*/
        //-------------------------------------------------------------------

        Call<apiResponse> apiResponseCall= service.getDepositTest(new DepositItem("123456", BigDecimal.valueOf(250.00)));

        apiResponseCall.enqueue(new Callback<apiResponse>() {
            @Override
            public void onResponse(Call<apiResponse> call, Response<apiResponse> response) {
                if (response.isSuccessful()){
                    apiResponse apiResponse = response.body();

                    Log.i(TAG, " CODE: "+ apiResponse.getCode());
                    Log.i(TAG, " MESSAGE: "+ apiResponse.getMessage());
                    Log.i(TAG, " REFERENCE: "+ apiResponse.getReference());

                }else{
                    Log.e(TAG," onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<apiResponse> call, Throwable t) {
                Log.e(TAG," onFailure: " + t.getMessage());

            }
        });
    }

    @Override
    protected int getLayout() {
        return -1;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status = data.getIntExtra(EXTRA_STATUS, STATUS_OK);

        if(status == STATUS_OK){
            intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivityForResult(intent, HOME_REQUEST);
        }else{
            finish();
        }
    }
}