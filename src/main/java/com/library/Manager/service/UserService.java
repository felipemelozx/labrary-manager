package com.library.Manager.service;

import com.library.Manager.model.DTO.UserDTO;
import com.library.Manager.model.UserModel;
import com.library.Manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

  public List<UserModel> findAllUsers() {
    return userRepository.findAll();
  }

  public UserModel findUserById(UUID id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found."));
  }

  public UserModel updateUser(UserModel user) {
    UserModel userRepo = userRepository.findById(user.getId())
        .orElseThrow(() -> new RuntimeException("User not found."));

    if(user.getRole().equals(null)){
      user.setRole(userRepo.getRole());
    }
      user.setCreatedAt(userRepo.getCreatedAt());
      user.setPassword(userRepo.getPassword());

    return userRepository.save(user);
  }

  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }
}
