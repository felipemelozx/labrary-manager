package com.library.Manager.service;

import com.library.Manager.model.AuthorModel;
import com.library.Manager.model.DTO.AuthorDTO;
import com.library.Manager.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public boolean createAuthor(AuthorDTO dto){
    var author = dto.fromToAuthorModel();
     if (authorRepository.save(author) != null){
       return true;
    }
     return false;
  }

  public List<AuthorModel> findAll(){
    return authorRepository.findAll();
  }

  public AuthorModel findById(Long id){
    return authorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Author not found."));
  }
}
