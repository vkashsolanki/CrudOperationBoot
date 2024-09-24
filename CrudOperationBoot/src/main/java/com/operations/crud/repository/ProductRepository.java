package com.operations.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operations.crud.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
	
	
	
	

}
