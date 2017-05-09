package com.unidigital.bicentenario.tbcomplus.api.pojo;

import java.math.BigDecimal;

/**
 * Created by Alejandro on 5/7/2017.
 */
public class DepositRequest extends HostRequest {

    private String account;

    private BigDecimal amount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}