package com.library.Manager.model;

public enum Roles {
  USER(0),
  ADMIN(1);

  private final int value;

  Roles(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static Roles fromValue(int value) {
    for (Roles role : Roles.values()) {
      if (role.getValue() == value) {
        return role;
      }
    }
    throw new IllegalArgumentException("Role not found for value " + value);
  }
}