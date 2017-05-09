package com.unidigital.bicentenario.tbcomplus.api.pojo;

import java.util.List;

public class LoginResponse extends HostResponse {

    private String
            CodRespuesta,
            DescripcionRespuesta,
            Nombre,
            FechaAcceso;

    private List<PhoneOperator> Listaoperadoras;
    private List<IdentifierAfi> Listatipoafi;

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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaAcceso() {
        return FechaAcceso;
    }

    public void setFechaAcceso(String fechaAcceso) {
        FechaAcceso = fechaAcceso;
    }

    public List<PhoneOperator> getListaoperadoras() {
        return Listaoperadoras;
    }

    public void setListaoperadoras(List<PhoneOperator> listaoperadoras) {
        Listaoperadoras = listaoperadoras;
    }

    public List<IdentifierAfi> getListatipoafi() {
        return Listatipoafi;
    }

    public void setListatipoafi(List<IdentifierAfi> listatipoafi) {
        Listatipoafi = listatipoafi;
    }
}