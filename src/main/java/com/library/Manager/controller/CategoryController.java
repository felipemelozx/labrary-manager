package com.library.Manager.controller;

import com.library.Manager.model.CategoryModel;
import com.library.Manager.model.DTO.CategoryDTO;
import com.library.Manager.service.CategoryService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  @RequestMapping("/create")
  public ResponseEntity createCategory(@RequestBody CategoryDTO dto) throws URISyntaxException {
    var categoryCreated = categoryService.createCategory(dto);
    if (categoryCreated){

      return ResponseEntity.created(new URI("/category/create")).build();
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping
  public ResponseEntity<List<CategoryModel>> findAll(){
    return ResponseEntity.ok().body(categoryService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryModel> findCategoryById(@PathVariable Long id){
    return ResponseEntity.ok().body(categoryService.findById(id));
  }

  @PutMapping("/update")
  public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel categoryModel){
    return ResponseEntity.ok().body(categoryService.update(categoryModel));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteCategory(@PathVariable Long id){
    categoryService.delete(id);
    return ResponseEntity.ok().build();
  }
}
