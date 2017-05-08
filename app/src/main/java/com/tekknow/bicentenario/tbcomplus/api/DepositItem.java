package com.tekknow.bicentenario.tbcomplus.api;

import java.math.BigDecimal;

/**
 * Created by Mercedes Rodriguez on 5/5/2017.
 */

public class DepositItem {
    private String account;
    private BigDecimal amount;

    public DepositItem(String account, BigDecimal amount){
        this.account = account;
        this.amount = amount;
    }

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
