package com.unidigital.bicentenario.tbcomplus.api.pojo;

public class TokenRequest extends HostRequest {

    private String username;
    private String serialpos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSerialpos() {
        return serialpos;
    }

    public void setSerialpos(String serialpos) {
        this.serialpos = serialpos;
    }
}
