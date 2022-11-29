package com.bmt.lab3.dto;

import java.io.Serializable;

public class Category extends TopBar implements Serializable {
    private String name;
    private String URL;

    public Category(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
