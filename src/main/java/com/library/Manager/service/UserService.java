package com.library.Manager.service;

import com.library.Manager.model.DTO.UserDTO;
import com.library.Manager.model.UserModel;
import com.library.Manager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean createUser(UserDTO userDto) {
    var user = userDto.fromUserModel();
     if(userRepository.save(user) != null){
       return true;
     }
    return false;
  }
}
