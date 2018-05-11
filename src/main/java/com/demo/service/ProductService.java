package com.demo.service;

import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import com.demo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Optional<Product> getProdctsByKeyword(RequestParamsDef requestParams) {
        System.out.println("-----getProdctsByKeyword------");
        if(Optional.ofNullable(requestParams).isPresent() && !StringUtils.isEmpty(requestParams.getKeywords())){
            //returns the product which matches the keyword
            Product product =   productDao.getProduct();
            if(Optional.ofNullable(product).isPresent() && requestParams.getKeywords().equals(product.getName())){
                return Optional.ofNullable(product);
            }
        }
        return Optional.empty();
    }

    public boolean isValid(RequestParamsDef requestParams){
        if(Optional.ofNullable(requestParams).isPresent() && !StringUtils.isEmpty(requestParams.getKeywords())){
            return true;
        } else{
            return false;
        }

    }
}
