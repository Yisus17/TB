package com.unidigital.bicentenario.tbcomplus.api;


import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class RestClient {
    private static RestClient instance = null;
    public static final String BASE_URL = "http://10.10.10.100:8080/quantum/"; //WebApiQuantumTBcom
    private HostApiEndpoint api;

    private static final int CONNECTION_TIMEOUT = 10;
    private static final int READ_TIMEOUT = 10;
    private static final int WRITE_TIMEOUT = 10;

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        try {
                            Response response = chain.proceed(chain.request());
                            String pepe = "pepe";
                            Log.i("PRUEBAS", String.valueOf(response.code()));
                        }
                        catch (SocketTimeoutException exception) {
                            exception.printStackTrace();
                            Response response = chain.proceed(chain.request());
                            Log.i("PRUEBAS", String.valueOf(response.code()));
                        }

                        return chain.proceed(chain.request());
                    }
                }
            )
            .build();





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
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        this.api = retrofit.create(HostApiEndpoint.class);
    }

    public HostApiEndpoint getApi() {
        return this.api;
    }

}
