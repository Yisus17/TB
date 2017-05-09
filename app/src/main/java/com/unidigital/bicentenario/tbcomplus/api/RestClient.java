package com.unidigital.bicentenario.tbcomplus.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class RestClient {
    private static RestClient instance = null;
    public static final String BASE_URL = "http://10.10.10.100:8080/quantum/"; //WebApiQuantumTBcom
    private HostApiEndpoint api;

    public static RestClient getInstance() {
        if (instance == null)
            instance = new RestClient();

        return instance;
    }

    protected RestClient() {
        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        this.api = retrofit.create(HostApiEndpoint.class);
    }

    public HostApiEndpoint getApi() {
        return this.api;
    }
}
