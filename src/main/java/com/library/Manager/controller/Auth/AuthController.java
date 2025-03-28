package com.library.Manager.controller.Auth;

import com.library.Manager.infra.security.TokenService;
import com.library.Manager.model.DTO.CreateUserDto;
import com.library.Manager.model.DTO.LoginDTO;
import com.library.Manager.model.DTO.ResponseLoginDTO;
import com.library.Manager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  private final TokenService tokenService;

  public AuthController(UserService repository, PasswordEncoder passwordEncoder, TokenService tokenService) {
    this.userService = repository;
    this.tokenService = tokenService;
  }

  @PostMapping("/register")
  public ResponseEntity<List<String>> register(@RequestBody CreateUserDto body){
    var fails = userService.register(body);
    if (fails.isEmpty()){
      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(body.email()).toUri();
      return ResponseEntity.created(location).build();
    }
    return ResponseEntity.badRequest().body(fails);
  }

  @PostMapping("/login")
  public ResponseEntity<ResponseLoginDTO> login(@RequestBody LoginDTO body){
    var token = userService.login(body);
    if(token != null){
      return ResponseEntity.ok().body(new ResponseLoginDTO(body.email(),token));
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }

  @PostMapping("/validate-token")
  public ResponseEntity<ResponseTokenValidDTO> isTokenValid(@RequestBody TokenValidDTO body){
    String isValid = tokenService.validateToken(body.token());
    boolean valid = isValid != null;
    return ResponseEntity.ok(new ResponseTokenValidDTO(valid));
  }
}
