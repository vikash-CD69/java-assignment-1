package com.npci.productmgnt.service;

import java.util.List;
import java.util.Map;

import com.npci.productmgnt.entity.Product;

@org.springframework.stereotype.Service
public interface Service {
	
	List<Product> getProducts();
    Product addProduct(Product product);
    Map<Object,Object> generateBills();
    boolean deleteProduct(int id);

}
