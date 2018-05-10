package com.demo.service;

import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    public Optional<Product> getProdctsByKeyword(RequestParamsDef requestParams) {

        if(Optional.ofNullable(requestParams).isPresent() && !StringUtils.isEmpty(requestParams.getKeywords())){
            //returns the product which matches the keyword
            Product product = new Product();
            product.setName("Prod1");
            return Optional.ofNullable(product);

        }
        return Optional.empty();
    }
}
