package org.ncu.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.app.entities.Product;
import org.ncu.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping(path = "/product/saveProduct")
	public String saveProductDetails(@RequestBody Product product) {
		String msg = productService.insertProduct(product);
		return msg;
	}
	
	@GetMapping(value = "/product/fetchProducts")
	public ResponseEntity<List<Product>> getProductDetails(){
		List<Product> list = new ArrayList<>();
		for(Product product : productService.fetchAllProducts().values()) {
			list.add(product);
		}
//		List<Product> list = (List<Product>) productService.fetchAllProducts().values();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/product/updateProduct/{id}")
	public ResponseEntity<Product> updateProductDetails(@PathVariable("id") int id, @RequestBody Product product) {
		Product p = productService.updateProduct(id, product);
		if(p != null)
			return new ResponseEntity<Product> (product, HttpStatus.OK);
		else
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/product/deleteProduct/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
