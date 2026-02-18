package com.rastrolocal.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rastrolocal.crud.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
  // No uso ninguno, pero podrían ser útiles
  Optional<ProductModel> findOneByTitle(String title);

  List<ProductModel> findByTitleContaining(String keyword);

  List<ProductModel> findByDescriptionContaining(String keyword);

  Optional<ProductModel> findOneByPrice(Double price);

  List<ProductModel> findByPriceBetween(Double minPrice, Double maxPrice);
}
