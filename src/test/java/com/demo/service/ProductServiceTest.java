package com.demo.service;


import com.demo.mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;


    @Test
    void validateProductRequestParams(){
        productService.
    }

}