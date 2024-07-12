package org.example.figma.service;

import org.example.figma.entity.Product;
import org.example.figma.model.dto.response.ProductResDto;
import org.example.figma.model.dto.response.TrendingOrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ResponseEntity<List<ProductResDto>> getAllProducts();

    Product findById(UUID id);

    List<Product> findAll();

    ResponseEntity<List<TrendingOrderDto>> getTrendingProducts();
}