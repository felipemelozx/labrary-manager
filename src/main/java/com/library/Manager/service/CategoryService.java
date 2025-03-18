package com.library.Manager.service;

import com.library.Manager.model.AuthorModel;
import com.library.Manager.model.CategoryModel;
import com.library.Manager.model.DTO.AuthorDTO;
import com.library.Manager.model.DTO.CategoryDTO;
import com.library.Manager.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public boolean createCategory(CategoryDTO dto){
    var category = dto.fromToCategoryModel();
    if (categoryRepository.save(category) != null){
      return true;
    }
    return false;
  }

  public List<CategoryModel> findAll(){
    return categoryRepository.findAll();
  }

  public CategoryModel findById(Long id){
    return categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found."));
  }
}
