package com.library.Manager.repository;


import com.library.Manager.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel, Long> {
  Optional<List<BookModel>> findAllByCategoryId(Long categoryId);

  Optional<List<BookModel>> findAllByAuthorId(Long authorId);
}
