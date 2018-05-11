package com.demo.service;


import com.demo.bean.Product;
import com.demo.bean.RequestParamsDef;
import com.demo.dao.ProductDao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//For JUnit 5 tests you can silent this exception using annotation provided in mockito-junit-jupiter package.
//@MockitoSettings(strictness = Strictness.LENIENT)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductDao productDao;

    @Test
    @DisplayName("Check Request Prams are empty or null")
    public void emptyOrNullCheckForProductRequestParams(){
        Product product = mock(Product.class);
        product.setName("iphone");
        product.setDescription("iphone 10");

        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("Prod1");

        final Optional<Product> resultProducts = productService.getProdctsByKeyword(requestParams);
       assertThat(productService.getProdctsByKeyword(requestParams),is(notNullValue()));
       //assertThat(productService.getProdctsByKeyword(requestParams).get().getName(),is(equalToIgnoringWhiteSpace("iphone")));
    }
    @Test
    void getProductsByKeyword() {
        RequestParamsDef requestParams = new RequestParamsDef();
        requestParams.setKeywords("Prod1");
        final Optional<Product> resultProducts = productService.getProdctsByKeyword(requestParams);
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                ()-> {
                    assertTrue(resultProducts.isPresent());
                    String name = resultProducts.get().getName();
                    // Executed only if the previous assertion is valid.
                    assertAll("search product",
                            () -> assertTrue(name.equals("Prod1"))
                    );
                });

    }

}