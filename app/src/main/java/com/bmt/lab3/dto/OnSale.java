package com.bmt.lab3.dto;

import lombok.Data;

import java.io.Serializable;

public class OnSale extends TopBar implements Serializable {
    private String name;

    public OnSale(String name) {
        this.name = name;
    }
    public OnSale(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
