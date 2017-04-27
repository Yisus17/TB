package com.tekknow.bicentenario.tbcomplus.api_models;

import com.tekknow.bicentenario.tbcomplus.api.item;
import java.util.ArrayList;

/**
 * Created by Jesus Arevalo on 4/27/2017.
 */

public class apiResponse {
    //Deben llamarse igual que los keys que queremos del JSON
    private int count;
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
    }
}
