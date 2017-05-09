package com.unidigital.bicentenario.tbcomplus.api.pojo;

/**
 * Created by Alejandro on 5/8/2017.
 */
public class LoginRequest extends HostRequest {

    private String
            username,
            password,
            serialpos,
            canal,
            telefono,
            imei,
            fechahora_disp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSerialpos() {
        return serialpos;
    }

    public void setSerialpos(String serialpos) {
        this.serialpos = serialpos;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getFechahora_disp() {
        return fechahora_disp;
    }

    public void setFechahora_disp(String fechahora_disp) {
        this.fechahora_disp = fechahora_disp;
    }
}