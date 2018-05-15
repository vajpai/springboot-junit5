package com.demo.controller;

import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getApplicatinInfo(){
        return "This is Spring boot Junit Application";
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(){
        RequestParamsDef requestParamsDef = new RequestParamsDef();
        requestParamsDef.setKeywords("iphone");
        return new ResponseEntity(productService.getProdctsByKeyword(requestParamsDef), HttpStatus.OK);
    }
}
