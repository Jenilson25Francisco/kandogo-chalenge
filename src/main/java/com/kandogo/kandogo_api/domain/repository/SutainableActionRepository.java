package com.kandogo.kandogo_api.domain.repository;

import com.kandogo.kandogo_api.domain.model.SutainableAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SutainableActionRepository extends JpaRepository<SutainableAction, String> {
}
