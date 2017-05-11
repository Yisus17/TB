package com.unidigital.bicentenario.tbcomplus.api.pojo;
import java.math.BigDecimal;

public class DepositRequest extends HostRequest implements Reversable {

    private String account;
    private BigDecimal amount;
    private boolean reverse;

    public DepositRequest(){
        reverse = false;
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

    @Override
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    @Override
    public boolean getReverse() {
        return reverse;
    }
}