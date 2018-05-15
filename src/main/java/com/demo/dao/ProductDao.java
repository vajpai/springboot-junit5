package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.bean.Product;

@Service
public class ProductDao {
	
	List<Product> products = new ArrayList<Product>();
   
	public List<Product> getProducts(){
		return products;
	}

    

}
