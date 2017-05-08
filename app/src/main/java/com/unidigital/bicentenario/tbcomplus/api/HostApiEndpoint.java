package com.unidigital.bicentenario.tbcomplus.api;

import com.unidigital.bicentenario.tbcomplus.model.DepositRequest;
import com.unidigital.bicentenario.tbcomplus.model.HostResponse;
import com.unidigital.bicentenario.tbcomplus.model.LoginRequest;
import com.unidigital.bicentenario.tbcomplus.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Alejandro on 5/7/2017.
 */
public interface HostApiEndpoint {

    @POST("deposit")
    Call<HostResponse> deposit(@Body DepositRequest request);

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);

}