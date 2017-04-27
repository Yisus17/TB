package com.tekknow.bicentenario.tbcomplus.api;
import com.tekknow.bicentenario.tbcomplus.api_models.apiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jesus Arevalo on 4/27/2017.
 */

public interface apiService {
    @GET("pokemon")
    Call<apiResponse> getInitData();
}
