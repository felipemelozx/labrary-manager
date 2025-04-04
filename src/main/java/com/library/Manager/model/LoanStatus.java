package com.library.Manager.model;

public enum LoanStatus {

  BORROWED(0),
  RETURNED(1),
  OVERDUE(3);

  private final int value;

  LoanStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static LoanStatus fromValue(int value) {
    for (LoanStatus status : LoanStatus.values()) {
      if (status.getValue() == value) {
        return status;
      }
    }
    throw new IllegalArgumentException("Role not found for value " + value);
  }
}
