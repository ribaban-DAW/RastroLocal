package com.rastrolocal.crud.service;

import java.util.List;
import java.util.Optional;

import com.rastrolocal.crud.model.UserModel;

public interface UserService {
  Optional<UserModel> findById(Long id);

  List<UserModel> findAll();

  UserModel save(UserModel User);

  Optional<UserModel> update(Long id, UserModel updatedUser);

  Boolean deleteById(Long id);
}
