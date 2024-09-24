package com.operations.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operations.crud.entity.Product;
import com.operations.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product p) {

		return productRepository.save(p);

	}
	//save all data at time
	public List<Product> saveProducts(List<Product> product) {

		return productRepository.saveAll(product);

	}
	//fetch all data at a time
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {

		return productRepository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {

		return productRepository.findByName(name);
	}

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product Removed"+id;

	}
	
	
	public Product updateProduct(Product product)
	{
		Product existingId = productRepository.findById(product.getId()).orElse(null);
		existingId.setName(product.getName());
		existingId.setQuantity(product.getQuantity());
		existingId.setPrice(product.getPrice());
		
		
		return productRepository.save(existingId);
	}
}
