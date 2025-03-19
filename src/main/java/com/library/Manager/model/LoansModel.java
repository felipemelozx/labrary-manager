package com.library.Manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
  private Long userId;

  @Column(name = "book_id", nullable = false)
  private Long bookId;

  @Column(name = "loan_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
  private LocalDateTime loanDate = LocalDateTime.now();

  @Column(name = "due_date", nullable = false)
  private LocalDateTime dueDate;

  @Column(name = "return_date")
  private LocalDateTime returnDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", length = 20, nullable = false)
  private LoanStatus status = LoanStatus.BORROWED;
}
