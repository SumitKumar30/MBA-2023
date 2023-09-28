package org.ncu.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.app.entities.Product;
import org.ncu.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping(path = "/saveProduct")
	public String saveProductDetails(@RequestBody Product product) {
		String msg = productService.insertProduct(product);
		return msg;
	}
	
	@GetMapping(value = "/fetchProducts")
	public ResponseEntity<List<Product>> getProductDetails(){
		List<Product> list = new ArrayList<>();
		for(Product product : productService.fetchAllProducts().values()) {
			list.add(product);
		}
//		List<Product> list = (List<Product>) productService.fetchAllProducts().values();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
}
