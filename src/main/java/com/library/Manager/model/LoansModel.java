package com.library.Manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_loans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoansModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "book_id", nullable = false)
  private Long bookId;

  @Column(name = "loan_date", nullable = false)
  private LocalDateTime loanDate;

  @Column(name = "due_date", nullable = false)
  private LocalDateTime dueDate;

  @Column(name = "return_date")
  private LocalDateTime returnDate;

  @Column(length = 20, name = "status")
  @Enumerated(EnumType.STRING)
  private LoanStatus status;
}
