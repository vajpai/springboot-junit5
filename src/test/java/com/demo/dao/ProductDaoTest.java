package com.demo.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.bean.Product;

@ExtendWith(MockitoExtension.class)
public class ProductDaoTest {

	@Mock
	ProductDao productDao;

	@Test
	public void emptyAndNullCheckGetProduct() {
		Product product = new Product("MI", "MI Note Pro");
		List<Product> products = Arrays.asList(product);
		when(productDao.getProducts()).thenReturn(products);
		assertThat(productDao.getProducts().get(0).getName(), equalTo(products.get(0).getName()));

	}
}
