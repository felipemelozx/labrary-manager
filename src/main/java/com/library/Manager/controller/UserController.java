package com.library.Manager.controller;



import com.library.Manager.model.UserModel;
import com.library.Manager.service.UserService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserModel>> getAllUsers() {
    return ResponseEntity.ok().body(userService.findAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserModel> getUserById(@PathVariable UUID id){
    return ResponseEntity.ok().body(userService.findUserById(id));
  }

  @PutMapping("/update")
  public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user){
    return ResponseEntity.ok().body(userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable UUID id){
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }

}
