package com.library.Manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 150)
  private String title;



  private Long authorId;

  @Column(nullable = false)
  private String publisher;

  @Column(length = 100, name = "publisher_year")
  private String publisherYear;

  private Long categoryId;

  @Column(name = "Available_copies", columnDefinition = "SMALLINT DEFAULT 0")
  private short availableCopies;

  @Column(name = "total_copies", columnDefinition = "SMALLINT DEFAULT 0")
  private short totalCopies;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  private String coverImage;

}
