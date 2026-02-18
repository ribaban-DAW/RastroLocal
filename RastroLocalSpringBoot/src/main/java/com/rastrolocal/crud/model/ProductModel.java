package com.rastrolocal.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 500)
  private String description;

  @Column(nullable = true)
  private String imageUrl;

  @Column(nullable = false)
  private Double price;

  @Override
  public String toString() {
    return "ProductModel{" +
        "id=" + id +
        ", title='" + title + "'" +
        ", description='" + description + "'" +
        ", imageUrl='" + imageUrl + "'" +
        ", price=" + price +
        '}';
  }
}
