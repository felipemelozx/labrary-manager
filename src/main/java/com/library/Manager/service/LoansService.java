package com.library.Manager.service;

import com.library.Manager.repository.LoansRepository;
import org.springframework.stereotype.Service;

@Service
public class LoansService {

  private final LoansRepository loansRepository;

  public LoansService(LoansRepository loansRepository) {
    this.loansRepository = loansRepository;
  }
}
