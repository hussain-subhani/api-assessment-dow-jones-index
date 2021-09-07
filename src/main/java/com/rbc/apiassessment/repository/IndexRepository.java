package com.rbc.apiassessment.repository;

import com.rbc.apiassessment.entity.IndexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndexRepository extends JpaRepository<IndexEntity, Long> {

    Optional<List<IndexEntity>> findByStock(String stock);
}
