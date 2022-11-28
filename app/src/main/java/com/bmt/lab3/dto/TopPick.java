package com.bmt.lab3.dto;

import lombok.Data;

import java.io.Serializable;

public class TopPick extends TopBar implements Serializable {
    private String name;

    public TopPick(String name) {
        this.name = name;
    }
    public TopPick(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
