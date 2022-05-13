package com.yasin.petclinicdemo.repository;

import com.yasin.petclinicdemo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit, Long> {
}
