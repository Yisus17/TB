package com.unidigital.bicentenario.tbcomplus.api;

import com.unidigital.bicentenario.tbcomplus.api.pojo.DepositRequest;
import com.unidigital.bicentenario.tbcomplus.api.pojo.DepositResponse;
import com.unidigital.bicentenario.tbcomplus.api.pojo.HostResponse;
import com.unidigital.bicentenario.tbcomplus.api.pojo.LoginRequest;
import com.unidigital.bicentenario.tbcomplus.api.pojo.LoginResponse;
import com.unidigital.bicentenario.tbcomplus.api.pojo.LogoutRequest;
import com.unidigital.bicentenario.tbcomplus.api.pojo.LogoutResponse;
import com.unidigital.bicentenario.tbcomplus.api.pojo.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HostApiEndpoint {

    @POST("/Token")
    Call<TokenResponse> getToken(@Body TokenResponse request);

    @POST("/api/Afiliacion/Loginmovil")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("/api/Account/Logout")
    Call<LogoutResponse> login(@Body LogoutRequest request);

    @POST("deposit")
    Call<DepositResponse> deposit(@Body DepositRequest request);



}