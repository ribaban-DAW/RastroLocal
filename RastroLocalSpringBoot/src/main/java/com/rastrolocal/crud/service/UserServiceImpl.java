package com.rastrolocal.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rastrolocal.crud.model.UserModel;
import com.rastrolocal.crud.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Profile("production")
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public Optional<UserModel> findById(Long id) {
    try {
      return userRepository.findById(id);
    } catch (Exception e) {
      System.err.println("Error finding user with id: " + id + ". Reason: " + e.getMessage());
      return Optional.empty();
    }
  }

  public List<UserModel> findAll() {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      System.err.println("Error finding all users. Reason: " + e.getMessage());
      return List.of();
    }
  }

  public UserModel save(UserModel User) {
    try {
      // Se debería hashear la contraseña antes de guardar
      return userRepository.save(User);
    } catch (Exception e) {
      System.err.println("Error saving user. Reason: " + e.getMessage());
      return null;
    }
  }

  public Optional<UserModel> update(Long id, UserModel updatedUser) {
    try {
      Optional<UserModel> existingUserOpt = userRepository.findById(id);
      if (existingUserOpt.isEmpty()) {
        return Optional.empty();
      }
      UserModel existingUser = existingUserOpt.get();
      if (updatedUser.getName() != null) {
        existingUser.setName(updatedUser.getName());
      }
      if (updatedUser.getEmail() != null) {
        existingUser.setEmail(updatedUser.getEmail());
      }
      if (updatedUser.getPassword() != null) {
        // Se debería hashear la contraseña antes de guardar
        existingUser.setPassword(updatedUser.getPassword());
      }
      return Optional.of(userRepository.save(existingUser));
    } catch (Exception e) {
      System.err.println("Error updating user with id: " + id + ". Reason: " + e.getMessage());
      return Optional.empty();
    }
  }

  public Boolean deleteById(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      System.err.println("Error deleting user with id: " + id + ". Reason: " + e.getMessage());
      return false;
    }
  }
}
