package com.library.Manager.controller;


import com.library.Manager.model.DTO.UserDTO;
import com.library.Manager.model.UserModel;
import com.library.Manager.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity createUser(@RequestBody UserDTO userDto) {
    if(userService.createUser(userDto)){
      return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
    return ResponseEntity.badRequest().build();
  }

}
