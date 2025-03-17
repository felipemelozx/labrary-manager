package com.library.Manager.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(length = 20)
  private String phone;

  private String address;

  @Column(length = 20)
  @Enumerated(EnumType.STRING)
  private Roles role = Roles.fromValue(1);

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  public void setPassword(String password) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    this.password = encoder.encode(password);
  }

}
