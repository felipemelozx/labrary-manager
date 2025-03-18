package com.library.Manager.model.DTO;

import com.library.Manager.model.CategoryModel;

public record CategoryDTO(String name) {

  public CategoryModel fromToCategoryModel(){
    return new CategoryModel(null, name);
  }
}
