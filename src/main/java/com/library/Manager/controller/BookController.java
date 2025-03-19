package com.library.Manager.controller;


import com.library.Manager.model.BookModel;
import com.library.Manager.model.DTO.BookTDO;
import com.library.Manager.service.BookService;
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

  @GetMapping("/{id}")
  public ResponseEntity<BookModel> getBookById(@PathVariable Long id){
    BookModel bookModel = bookService.findById(id);
    return ResponseEntity.ok().body(bookModel);
  }

  @PutMapping("/update")
  public ResponseEntity<BookModel> updateBook(@RequestBody BookModel dto){
    BookModel book = bookService.update(dto);
    return ResponseEntity.ok().body(book);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteBook(@PathVariable Long id){
    bookService.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<BookModel>> getAllBooksByCategory(@PathVariable Long categoryId){
    List<BookModel> bookModelList = bookService.findAllByCategory(categoryId);
    return ResponseEntity.ok().body(bookModelList);
  }
  @GetMapping("/author/{authorId}")
  public ResponseEntity<List<BookModel>> getAllBooksByAuthor(@PathVariable Long authorId){
    List<BookModel> bookModelList = bookService.findAllByAuthor(authorId);
    return ResponseEntity.ok().body(bookModelList);
  }
}
