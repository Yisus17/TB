package com.tekknow.bicentenario.tbcomplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import com.tekknow.bicentenario.tbcomplus.apitest.*;

import java.util.ArrayList;

public class apiTest extends AppCompatActivity {
    private Retrofit retrofit;
    private static final  String TAG= "POKEDEX: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getData();
    }

    private void getData() {
        testService service = retrofit.create(testService.class);
        Call <testResponse> testResponseCall = service.getAll();

        testResponseCall.enqueue(new Callback<testResponse>() {
            @Override
            public void onResponse(Call<testResponse> call, Response<testResponse> response) {
                 if (response.isSuccessful()){
                     testResponse testResponse= response.body();
                     ArrayList<item> listItem= testResponse.getResults();
                     for (int i=0; i<listItem.size();i++){
                         item it=listItem.get(i);
                         Log.i(TAG, "Pokemon: " +it.getName());
                     }
                 }else {
                     Log.e(TAG, "onResponse: "+response.errorBody());
                 }
            }

            @Override
            public void onFailure(Call<testResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

}
