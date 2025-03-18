package com.library.Manager.repository;

import com.library.Manager.model.AuthorModel;
import com.library.Manager.model.CategoryModel;
import com.library.Manager.model.DTO.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
