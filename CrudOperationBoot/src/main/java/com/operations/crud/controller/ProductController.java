package com.operations.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operations.crud.entity.Product;
import com.operations.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	


	@PostMapping("/addProduct")
	public Product addProducts(@RequestBody Product products) {

		return productService.saveProduct(products);

	}

	@PostMapping("/addProducts")
	public List<Product> addAllProduct(@RequestBody List<Product> allProduct) {

		return productService.saveProducts(allProduct);

	}
	
	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productService.getProduct();
	}


	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {

		return productService.getProductById(id);
	}

	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@PutMapping("/updateProduct")
	public Product updateByProduct(@RequestBody Product productUpdate) {
		return productService.updateProduct(productUpdate);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {

		return productService.deleteProduct(id);
	}
	
}
