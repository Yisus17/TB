package com.unidigital.bicentenario.tbcomplus.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * Created by Alejandro on 5/7/2017.
 */
public class DepositRequest extends HostRequest implements Parcelable {

    private String account;
    private Double amount;

    public DepositRequest(){

    }

    public DepositRequest(Parcel in) {
        account = in.readString();
        amount = in.readDouble();
    }

    public static final Creator<DepositRequest> CREATOR = new Creator<DepositRequest>() {
        @Override
        public DepositRequest createFromParcel(Parcel in) {
            return new DepositRequest(in);
        }

        @Override
        public DepositRequest[] newArray(int size) {
            return new DepositRequest[size];
        }
    };

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(account);
        dest.writeDouble(amount);
    }
}