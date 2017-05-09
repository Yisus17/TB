package com.unidigital.bicentenario.tbcomplus.api.pojo;

import java.io.Serializable;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class IdentifierAfi implements Serializable {
    private String Codigo, Descripcion;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
