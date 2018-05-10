package com.demo.service;


import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import com.demo.mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;


    @Test
    @DisplayName("Check Request Prams are empty or null")
    void emptyOrNullCheckForProductRequestParams(){
        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("Prod1");
        assertNotNull(productService.getProdctsByKeyword(requestParams),"Keyword should not be empty or null");
    }
    @Test
    void getProductsByKeyword() {
        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("Prod1");
        Product product = new Product();
        product.setName("Prod1");
        final Optional<Product> resultProducts = productService.getProdctsByKeyword(requestParams);
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                ()-> {
                    assertNotNull(product);
                    String name = product.getName();
                    // Executed only if the previous assertion is valid.
                    assertAll("search product",
                            () -> assertTrue(name.equals("Prod1"))
                    );
                });

    }

}