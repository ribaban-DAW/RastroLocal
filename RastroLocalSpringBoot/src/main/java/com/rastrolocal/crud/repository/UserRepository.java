package com.rastrolocal.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rastrolocal.crud.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  // No lo uso, pero podría ser útil
  Optional<UserModel> findOneByEmail(String email);
}
