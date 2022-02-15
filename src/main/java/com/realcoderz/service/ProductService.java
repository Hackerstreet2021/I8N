package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.Product;


public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}