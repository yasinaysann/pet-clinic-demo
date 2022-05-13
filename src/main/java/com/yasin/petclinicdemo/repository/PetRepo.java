package com.yasin.petclinicdemo.repository;

import com.yasin.petclinicdemo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Long> {
}
