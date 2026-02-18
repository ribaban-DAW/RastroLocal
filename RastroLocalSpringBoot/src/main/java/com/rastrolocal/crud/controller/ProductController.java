package com.rastrolocal.crud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rastrolocal.crud.model.ProductModel;
import com.rastrolocal.crud.service.ProductService;

@RestController
// Podría ser "/api/v1" para tener versionado, pero lo dejo sencillito
@RequestMapping("/api")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<ProductModel> product = this.productService.findById(id);
    if (product.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha encontrado el producto con id " + id);
    }
    return ResponseEntity.ok(product.get());
  }

  @GetMapping("/products")
  public ResponseEntity<?> findAll() {
    List<ProductModel> products = this.productService.findAll();
    if (products.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No existen productos");
    }
    return ResponseEntity.ok(products);
  }

  @PostMapping("/products")
  public ResponseEntity<ProductModel> save(@RequestBody ProductModel product) {
    try {
      ProductModel savedProduct = this.productService.save(product);
      URI location = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(savedProduct.getId())
          .toUri();
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .location(location)
          .body(savedProduct);
    } catch (Exception e) {
      System.err.println("Error saving product: " + e.getMessage());
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .build();
    }
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductModel updatedProduct) {
    Optional<ProductModel> updated = this.productService.update(id, updatedProduct);
    if (updated.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha podido actualizar el producto con id " + id);
    }
    return ResponseEntity.ok(updated.get());
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    Boolean deleted = this.productService.deleteById(id);
    if (!deleted) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha podido eliminar el producto con id " + id);
    }
    return ResponseEntity.ok().build();
  }
}
