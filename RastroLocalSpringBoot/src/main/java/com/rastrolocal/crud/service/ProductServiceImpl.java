package com.rastrolocal.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rastrolocal.crud.model.ProductModel;
import com.rastrolocal.crud.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Profile("production")
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public Optional<ProductModel> findById(Long id) {
    try {
      return productRepository.findById(id);
    } catch (Exception e) {
      System.err.println("Error finding product with id: " + id + ". Reason: " + e.getMessage());
      return Optional.empty();
    }
  }

  public List<ProductModel> findAll() {
    return productRepository.findAll();
  }

  public ProductModel save(ProductModel product) {
    return productRepository.save(product);
  }

  public Optional<ProductModel> update(Long id, ProductModel updatedProduct) {
    try {
      Optional<ProductModel> existingProductOpt = productRepository.findById(id);
      if (existingProductOpt.isEmpty()) {
        return Optional.empty();
      }
      ProductModel existingProduct = existingProductOpt.get();

      // Para actualizar campos específicos, por ejemplo, solo el title
      if (updatedProduct.getTitle() != null) {
        existingProduct.setTitle(updatedProduct.getTitle());
      }
      if (updatedProduct.getDescription() != null) {
        existingProduct.setDescription(updatedProduct.getDescription());
      }
      if (updatedProduct.getPrice() != null) {
        existingProduct.setPrice(updatedProduct.getPrice());
      }
      if (updatedProduct.getImageUrl() != null) {
        existingProduct.setImageUrl(updatedProduct.getImageUrl());
      }
      ProductModel savedProduct = productRepository.save(existingProduct);
      return Optional.of(savedProduct);
    } catch (Exception e) {
      System.err.println("Error updating product with id: " + id + ". Reason: " + e.getMessage());
      return Optional.empty();
    }
  }

  public Boolean deleteById(Long id) {
    try {
      productRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      System.err.println("Error deleting product with id: " + id + ". Reason: " + e.getMessage());
      return false;
    }
  }
}
