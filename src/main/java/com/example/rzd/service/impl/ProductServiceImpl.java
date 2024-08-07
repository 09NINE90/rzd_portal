package com.example.rzd.service.impl;

import com.example.rzd.entity.Product;
import com.example.rzd.repository.ProductsRepository;
import com.example.rzd.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    final
    ProductsRepository productsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findFirst30();
    }

    @Override
    public List<Product> findByColumnNameContaining(String query) {
        return productsRepository.findByProductNameContaining(query);
    }

    @Override
    public boolean existsByProductId(Long productId) {
        return productsRepository.existsByProductId(productId);
    }

    @Override
    public Product getProductById(long id) {
        return productsRepository.findById(id).orElse(null);
    }

}
