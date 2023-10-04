package org.ncu.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ncu.app.entities.Product;
import org.ncu.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public String insertProduct(Product product) {
		Product p = productRepository.save(product);
		if (p == null)
			return "Failed to save the product details!!!!";
		return "Product saved successfully with id -> " + p.getProductId();
	}

	@Override
	public Map<Integer, Product> fetchAllProducts() {
		List<Product> list = productRepository.findAll();
		Map<Integer, Product> map = new HashMap<Integer, Product>();
		for (Product p : list) {
//			list.get(p.getProductId());
			System.out.println(p);
			map.put(p.getProductId(), p);
		}
		return map;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Optional<Product> p = productRepository.findById(id);

		if (p.isPresent()) {
			Product p_temp = p.get();
			p_temp.setProductPrice(product.getProductPrice());
			p_temp.setProductName(product.getProductName());
			p_temp.setProductDescription(product.getProductDescription());
			p_temp.setProductUrl(product.getProductDescription());
			p_temp.setProductAvailability(product.isProductAvailability());
//			System.out.println("Details: "+product);
			return productRepository.save(product);
		} else {
			return null;
		}

//		p1.setProductAvailability(p1.getProductAvailability());
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		System.out.println("Product deleted successfully!!");
	}

}
