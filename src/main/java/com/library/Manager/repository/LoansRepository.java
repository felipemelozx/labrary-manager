package com.library.Manager.repository;

import com.library.Manager.model.LoansModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<LoansModel, Long> {
}
