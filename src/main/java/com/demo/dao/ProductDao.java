package com.demo.dao;

import com.demo.bean.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductDao {
    private Product product;

    public Product getProduct() {
        this.product = new Product("iphone","iphone 10");
        return product;
    }

}
