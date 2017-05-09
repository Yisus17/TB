package com.unidigital.bicentenario.tbcomplus.api.pojo;
import java.io.Serializable;

public class PhoneOperator implements Serializable {

    private String codigo, nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }
}
