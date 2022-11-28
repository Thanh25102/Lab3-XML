package com.bmt.lab3.dto;

import lombok.Data;

import java.io.Serializable;

public class Category extends TopBar implements Serializable {
    private String name;
    private Class parserDTO;

    public Category(String name,Class parserDTO) {
        this.name = name;
        this.parserDTO = parserDTO;
    }
    public Category(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getParserDTO() {
        return parserDTO;
    }

    public void setParserDTO(Class parserDTO) {
        this.parserDTO = parserDTO;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
