package com.unidigital.bicentenario.tbcomplus.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Mercedes Rodriguez on 5/8/2017.
 */

public class DepositResponse extends HostResponse implements Parcelable {
    private List<PhoneOperator> listaOperadoras;

    public DepositResponse(){}

    protected DepositResponse(Parcel in) {
        listaOperadoras = in.createTypedArrayList(PhoneOperator.CREATOR);
    }

    public static final Creator<DepositResponse> CREATOR = new Creator<DepositResponse>() {
        @Override
        public DepositResponse createFromParcel(Parcel in) {
            return new DepositResponse(in);
        }

        @Override
        public DepositResponse[] newArray(int size) {
            return new DepositResponse[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listaOperadoras);
    }
}
