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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, length = 100, unique = true)
  private String email;

  @Column(nullable = false, length = 255)
  private String password;

  @Override
  public String toString() {
    return "UserModel{" +
        "id=" + id +
        ", name='" + name + "'" +
        ", email='" + email + "'" +
        ", password='" + password + "'" +
        '}';
  }
}
