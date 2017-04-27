package com.tekknow.bicentenario.tbcomplus.apitest;

import retrofit2.Call;
import com.tekknow.bicentenario.tbcomplus.apitest.testResponse;
import retrofit2.http.GET;
/**
 * Created by Jesus Arevalo on 4/26/2017.
 */

public interface testService {

    @GET("pokemon")
    Call <testResponse> getAll();
}
