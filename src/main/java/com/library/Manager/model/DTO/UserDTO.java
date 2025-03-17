package com.library.Manager.model.DTO;

import com.library.Manager.model.Roles;
import com.library.Manager.model.UserModel;


import java.time.LocalDateTime;

public record UserDTO(String name,
                      String email,
                      String phone,
                      String password,
                      String address){
  public UserModel fromUserModel() {
    UserModel userModel = new UserModel();
    userModel.setName(name);
    userModel.setEmail(email);
    userModel.setPhone(phone);
    userModel.setPassword(password);
    userModel.setAddress(address);
    userModel.setCreatedAt(LocalDateTime.now());
    return userModel;
  }
}
