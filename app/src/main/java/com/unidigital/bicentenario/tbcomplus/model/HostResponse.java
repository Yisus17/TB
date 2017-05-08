package com.unidigital.bicentenario.tbcomplus.model;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Created by Alejandro on 5/7/2017.
 */
public class HostResponse implements Serializable {

    private Integer code;

    private String message;

    private Long reference;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return MessageFormat.format("HostResponse -> {0}, {1}, {2}", code, message, reference);
    }

}