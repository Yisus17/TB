package com.unidigital.bicentenario.tbcomplus.api.pojo;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class LogoutResponse extends HostResponse {
    private String CodRespuesta, DescripcionRespuesta;

    public String getCodRespuesta() {
        return CodRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        CodRespuesta = codRespuesta;
    }

    public String getDescripcionRespuesta() {
        return DescripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        DescripcionRespuesta = descripcionRespuesta;
    }
}
