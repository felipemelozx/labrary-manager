package com.library.Manager.service;

import com.library.Manager.infra.security.TokenService;
import com.library.Manager.model.DTO.CreateUserDto;
import com.library.Manager.model.DTO.LoginDTO;
import com.library.Manager.model.UserModel;
import com.library.Manager.repository.UserRepository;
import com.library.Manager.utils.Check;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final TokenService tokenService;

  public UserService(UserRepository userRepository, TokenService tokenService) {
    this.userRepository = userRepository;
    this.tokenService = tokenService;
  }

  @Transactional
  public List<String> register(CreateUserDto userDto) {
    var errors = Check.validatePasswordAndEmail(userDto.password(), userDto.email());

    if (errors.isEmpty()) {
      var user = userDto.fromUserModel();
      userRepository.save(user);
    }
    return errors;
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

  public String login(LoginDTO userLogin) {
    UserModel user = userRepository.findByEmail(userLogin.email())
        .orElseThrow(() -> new RuntimeException("User not found."));

    if(user.checkPassword(userLogin.password())){
      return this.tokenService.generateToken(user);
    };
    return null;
  }
}
