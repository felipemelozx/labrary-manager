package com.library.Manager.controller;

import com.library.Manager.service.LoansService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansController {

  private final LoansService loansService;

  public LoansController(LoansService loansService) {
    this.loansService = loansService;
  }
}
