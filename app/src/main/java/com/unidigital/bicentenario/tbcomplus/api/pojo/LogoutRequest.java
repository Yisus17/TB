package com.unidigital.bicentenario.tbcomplus.api.pojo;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class LogoutRequest extends HostRequest {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
