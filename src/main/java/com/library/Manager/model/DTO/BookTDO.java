package com.library.Manager.model.DTO;

import com.library.Manager.model.BookModel;

import java.time.LocalDateTime;

public record BookTDO(String title,
                      Long author,
                      String publisher,
                      String publisherYear,
                      Long category,
                      short availableCopies,
                      short totalCopies) {

public BookModel fromToBookModel(){
  return new BookModel(null, title, null, publisher,
      publisherYear, null, availableCopies, totalCopies, null);
}
}
