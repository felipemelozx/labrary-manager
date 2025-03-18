package com.library.Manager.model.DTO;

import com.library.Manager.model.AuthorModel;

public record AuthorDTO(String name) {

  public AuthorModel fromToAuthorModel(){
    return new AuthorModel(null, name);
  }
}
