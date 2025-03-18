package com.library.Manager.controller;


import com.library.Manager.model.BookModel;
import com.library.Manager.model.DTO.BookTDO;
import com.library.Manager.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  @RequestMapping("/create")
  public ResponseEntity createAuthor(@RequestBody BookTDO dto) throws URISyntaxException {
    var bookCreated = bookService.createBook(dto);
    if (bookCreated){
      return ResponseEntity.created(new URI("/book/create")).build();
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping
  public ResponseEntity<List<BookModel>> findAll(){
    return ResponseEntity.ok().body(bookService.findAll());
  }
}
