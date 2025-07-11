package com.cognizant.spring_learn.model;

public class Country {
    private String code;
    private String name;

    public Country() {
        System.out.println("Inside Country Constructor.");
    }

    public String getCode() {
        System.out.println("Inside getCode()");
        return code;
    }

    public void setCode(String code) {
        System.out.println("Inside setCode()");
        this.code = code;
    }

    public String getName() {
        System.out.println("Inside getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("Inside setName()");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
