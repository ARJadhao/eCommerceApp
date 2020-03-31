package com.workfromhome.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workfromhome.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
