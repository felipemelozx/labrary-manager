package com.library.Manager.service;

import com.library.Manager.model.BookModel;
import com.library.Manager.model.DTO.BookTDO;
import com.library.Manager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final CategoryService categoryService;
  private final AuthorService authorService;

  public BookService(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService) {
    this.bookRepository = bookRepository;
    this.categoryService = categoryService;
    this.authorService = authorService;
  }

  public List<BookModel> findAll() {
    return bookRepository.findAll();
  }

  public boolean createBook(BookTDO dto){
    var book = dto.fromToBookModel();

      if(categoryService.findById(dto.category()) != null){
        book.setCategoryId(dto.category());
      }
      if (authorService.findById(dto.author()) != null){
        book.setAuthorId(dto.author());
      }
      book.setCreatedAt(LocalDateTime.now());
      bookRepository.save(book);
      return true;
  }
}
