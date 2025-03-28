package com.library.Manager.service;

import com.library.Manager.model.BookModel;
import com.library.Manager.model.LoanStatus;
import com.library.Manager.model.LoansModel;
import com.library.Manager.repository.LoansRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoansService {

  private final BookService bookService;
  private final UserService userService;
  private final LoansRepository loansRepository;

  public LoansService(BookService bookService, UserService userService, LoansRepository loansRepository) {
    this.bookService = bookService;
    this.userService = userService;
    this.loansRepository = loansRepository;
  }

  public LoansModel createLoan(LoansModel loansModel) {
    if (loansModel.getLoanDate().isAfter(LocalDateTime.now())) {
      throw new IllegalArgumentException("The loan date cannot be a future date.");
    }
    var book = bookService.findById(loansModel.getBookId());
    // throw erro if user not exist.
    userService.findUserByEmail(loansModel.getUserEmail());
    if (book.getAvailableCopies() != 0){
      short newValue = (short) (book.getAvailableCopies() - 1);
      book.setAvailableCopies(newValue);
      bookService.update(book);
    } else {
      throw new IllegalArgumentException("There are no available copies of the book.");
    }

    return loansRepository.save(loansModel);
  }

  public List<LoansModel> getAllLoans(){
    return loansRepository.findAll();
  }

  public LoansModel getloanById(Long loanId) {
    return loansRepository.findById(loanId)
        .orElseThrow(() -> new RuntimeException("loans not found."));
  }

  public void delete(Long loanId) {
    loansRepository.deleteById(loanId);
  }

  public LoansModel returnBook(Long loanId) {
    LoansModel loansModelRepo = loansRepository.findById(loanId)
        .orElseThrow(() -> new RuntimeException("loans not found."));

    if(loansModelRepo.getStatus().equals(LoanStatus.RETURNED)){
      throw new RuntimeException("The book has already been returned.");
    }

    BookModel book = bookService.findById(loansModelRepo.getBookId());
    var newValue = (short) (book.getAvailableCopies() + 1);
    book.setAvailableCopies(newValue);
    bookService.update(book);

    loansModelRepo.setStatus(LoanStatus.fromValue(1));
    loansModelRepo.setReturnDate(LocalDateTime.now());
    return loansRepository.save(loansModelRepo);
  }
}
