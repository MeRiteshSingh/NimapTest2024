package com.coder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
