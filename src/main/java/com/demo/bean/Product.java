package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Product {
    private String name;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
