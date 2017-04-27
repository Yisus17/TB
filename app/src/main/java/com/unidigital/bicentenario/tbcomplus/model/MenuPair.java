package com.tekknow.bicentenario.tbcomplus.model;


public class MenuPair {
    private String key;
    private int value;

    public MenuPair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return this.key.toUpperCase();
    }
}
