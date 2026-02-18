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

import com.rastrolocal.crud.model.UserModel;
import com.rastrolocal.crud.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<UserModel> user = this.userService.findById(id);
    if (user.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha encontrado el usuario con id " + id);
    }
    return ResponseEntity.ok(user.get());
  }

  @GetMapping("/users")
  public ResponseEntity<?> findAll() {
    List<UserModel> users = this.userService.findAll();
    if (users.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No existen usuarios");
    }
    return ResponseEntity.ok(users);
  }

  @PostMapping("/users")
  public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
    try {
      UserModel savedUser = this.userService.save(user);
      URI location = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(savedUser.getId())
          .toUri();

      return ResponseEntity
          .status(HttpStatus.CREATED)
          .location(location)
          .body(savedUser);
    } catch (Exception e) {
      System.err.println("Error saving user. Reason: " + e.getMessage());
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .build();
    }
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserModel updatedUser) {
    Optional<UserModel> updated = this.userService.update(id, updatedUser);
    if (updated.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha encontrado el usuario con id " + id);
    }
    return ResponseEntity.ok(updated.get());
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    Boolean deleted = this.userService.deleteById(id);
    if (!deleted) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("No se ha encontrado el usuario con id " + id);
    }
    return ResponseEntity.ok().build();
  }
}
