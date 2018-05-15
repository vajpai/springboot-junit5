package com.demo.service;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import com.demo.dao.ProductDao;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductDao productDao;

    @Test
    @DisplayName("Check Request Prams are empty or null")
    public void emptyOrNullCheckForProductRequestParams(){
        Product product = new Product("iphone","iphone 10");
        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("iphone");
        List<Product> products = Arrays.asList(product);
        when(productService.getProdctsByKeyword(requestParams)).thenReturn(products);
        assertThat(productService.getProdctsByKeyword(requestParams).get(0).getName(), equalTo(product.getName()));

    }
    @Test
    void getProductsByKeyword() {
        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("Prod1");
        Product product = new Product("iphone","iphone 10");
        List<Product> products = Arrays.asList(product);
        when(productService.getProdctsByKeyword(requestParams)).thenReturn(products);
        final List<Product> resultProducts = productService.getProdctsByKeyword(requestParams);
        
        assertThat(resultProducts.get(0).getName(),equalTo(products.get(0).getName()));
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
      assertAll("properties",
                ()-> {
                    assertNotNull(resultProducts);
                    String name = resultProducts.get(0).getName();
                    assertNotNull(name);
                    // Executed only if the previous assertion is valid.
                    assertAll("search product",
                            () -> assertTrue(name.equals("iphone"))
                    );
                });

    }

}