package com.library.Manager.controller;

import com.library.Manager.model.AuthorModel;
import com.library.Manager.model.DTO.AuthorDTO;
import com.library.Manager.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping
  @RequestMapping("/create")
  public ResponseEntity createAuthor(@RequestBody AuthorDTO dto){
    var authorCreated = authorService.createAuthor(dto);
    if (authorCreated){
      return ResponseEntity.ok(HttpStatus.CREATED);
    }
    return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
  }

  @GetMapping
  public ResponseEntity<List<AuthorModel>> findAll(){
    return ResponseEntity.ok().body(authorService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AuthorModel> getAuthorById(@PathVariable Long id){
    var author = authorService.findById(id);
    return ResponseEntity.ok().body(author);
  }

  @PutMapping
  public ResponseEntity<AuthorModel> updateAuthor(@RequestBody AuthorModel dto){
    var author = authorService.update(dto);
    return ResponseEntity.ok().body(author);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity deleteAuthor(@PathVariable Long id){
    authorService.delete(id);
    return ResponseEntity.ok().build();
  }
}
