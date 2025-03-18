package com.library.Manager.repository;

import com.library.Manager.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
}
