package com.library.Manager.model.DTO;

import com.library.Manager.model.LoanStatus;
import com.library.Manager.model.LoansModel;

import java.time.LocalDateTime;
import java.util.UUID;

public record LoansDTO(Long bookId,
                       String userEmail,
                       LocalDateTime borrowDate,
                       LocalDateTime dueDate) {

  public LoansModel fromToLoansModel(){
    return new LoansModel(null, this.userEmail(), this.bookId(), this.borrowDate(), this.dueDate(),
        null, LoanStatus.fromValue(0));
  }
}
