package com.unidigital.bicentenario.tbcomplus.api.pojo;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class DepositResponse extends HostResponse {
    private List<PhoneOperator> listaOperadoras;

    public List<PhoneOperator> getListaOperadoras() {
        return listaOperadoras;
    }

    public void setListaOperadoras(List<PhoneOperator> listaOperadoras) {
        this.listaOperadoras = listaOperadoras;
    }

    @Override
    public String toString() {
        return super.toString().concat(listaOperadoras.toString());
    }
}
