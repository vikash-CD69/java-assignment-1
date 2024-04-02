package com.npci.productmgnt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.productmgnt.entity.Product;
import com.npci.productmgnt.service.Service;

@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	private Service service;

	@GetMapping
	public List<Product> findAllProducts() {
		return service.getProducts();
	}

	@GetMapping("/generateBill")
	public Map<Object, Object> generateBill() {
		return service.generateBills();
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = service.addProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

//	@DeleteMapping("/delete/{productId}")
//    public ResponseEntity<String> deleteProductById(@PathVariable int productId) {
//        if (Service.deleteProduct(productId)) {
//            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Product with ID " + productId + " not found", HttpStatus.NOT_FOUND);
//        }
//    }

}
