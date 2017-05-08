package com.tekknow.bicentenario.tbcomplus.api_models;

/**
 * Created by Jesus Arevalo on 4/27/2017.
 */

public class apiResponse {
    //Deben llamarse igual que los keys que queremos del JSON

    private int code;
    private String message;
    private int reference;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    /*private int count;
    private ArrayList<item> results;
    private String previous;
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<item> getResults() {
        return results;
    }

    public void setResults(ArrayList<item> results) {
        this.results = results;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }*/
}
