package com.unidigital.bicentenario.tbcomplus.model;

/**
 * Created by Alejandro on 5/8/2017.
 */
public class LoginRequest extends HostRequest {

    private String username;

    private String pin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}