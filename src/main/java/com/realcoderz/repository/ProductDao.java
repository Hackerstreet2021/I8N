package com.realcoderz.repository;

import org.springframework.data.repository.CrudRepository;

import com.realcoderz.model.Product;


public interface ProductDao extends CrudRepository<Product, Long> {

}