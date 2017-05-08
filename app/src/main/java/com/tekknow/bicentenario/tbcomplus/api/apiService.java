package com.tekknow.bicentenario.tbcomplus.api;
import com.google.gson.JsonObject;
import com.tekknow.bicentenario.tbcomplus.api_models.apiResponse;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Jesus Arevalo on 4/27/2017.
 */

public interface apiService {

    @POST("deposit")
    //Call<JsonObject> getDepositTest(@Body JsonObject item);
    Call<apiResponse> getDepositTest(@Body DepositItem item);
}
