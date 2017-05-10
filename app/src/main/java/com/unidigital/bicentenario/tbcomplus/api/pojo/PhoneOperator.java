package com.unidigital.bicentenario.tbcomplus.api.pojo;
import android.os.Parcel;
import android.os.Parcelable;


public class PhoneOperator implements Parcelable {

    private String codigo, nombre;

    public PhoneOperator(){}

    protected PhoneOperator(Parcel in) {
        codigo = in.readString();
        nombre = in.readString();
    }

    public static final Creator<PhoneOperator> CREATOR = new Creator<PhoneOperator>() {
        @Override
        public PhoneOperator createFromParcel(Parcel in) {
            return new PhoneOperator(in);
        }

        @Override
        public PhoneOperator[] newArray(int size) {
            return new PhoneOperator[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(nombre);
    }
}
