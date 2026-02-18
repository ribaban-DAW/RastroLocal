package com.rastrolocal.crud.service;

import java.util.List;
import java.util.Optional;

import com.rastrolocal.crud.model.ProductModel;

public interface ProductService {
  Optional<ProductModel> findById(Long id);

  List<ProductModel> findAll();

  ProductModel save(ProductModel product);

  Optional<ProductModel> update(Long id, ProductModel updatedProduct);

  Boolean deleteById(Long id);
}
