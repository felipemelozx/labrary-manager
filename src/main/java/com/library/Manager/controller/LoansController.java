package com.library.Manager.controller;

import com.library.Manager.model.DTO.LoansDTO;
import com.library.Manager.model.LoansModel;
import com.library.Manager.service.LoansService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansController {

  private final LoansService loansService;

  public LoansController(LoansService loansService) {
    this.loansService = loansService;
  }

  @PostMapping("/create")
  public ResponseEntity<LoansModel> createLoan(@RequestBody LoansDTO loansDTO){
    LoansModel loans = loansService.createLoan(loansDTO.fromToLoansModel());
    return ResponseEntity.ok().body(loans);
  }

  @GetMapping
  public ResponseEntity<List<LoansModel>> getAllLoans(){
    return ResponseEntity.ok().body(loansService.getAllLoans());
  }

  @GetMapping("/{loanId}")
  public ResponseEntity<LoansModel> getLoansById(@PathVariable Long loanId){
    return ResponseEntity.ok().body(loansService.getloanById(loanId));
  }

  @PutMapping("/{loanId}")
  public ResponseEntity<LoansModel> returnBookLoan(@PathVariable Long loanId){
    return ResponseEntity.ok().body(loansService.returnBook(loanId));
  }

  @DeleteMapping("/{loanId}")
  public ResponseEntity deleteLoan(@PathVariable Long loanId){
    loansService.delete(loanId);
    return ResponseEntity.ok().build();
  }

}
