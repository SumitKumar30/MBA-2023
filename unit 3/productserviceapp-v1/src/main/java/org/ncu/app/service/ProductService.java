package org.ncu.app.service;

import java.util.List;
import java.util.Map;

import org.ncu.app.entities.Product;

public interface ProductService {
	public String insertProduct(Product product);
	public Map<Integer, Product> fetchAllProducts();
	public Product updateProduct(int id, Product product);
	public void deleteProduct(int id);
}
