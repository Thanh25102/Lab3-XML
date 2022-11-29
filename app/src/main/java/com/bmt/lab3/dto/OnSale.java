package com.bmt.lab3.dto;

import lombok.Data;

import java.io.Serializable;

public class OnSale extends TopBar implements Serializable {
    private String name;
    private String URL;

    public OnSale(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public OnSale(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
