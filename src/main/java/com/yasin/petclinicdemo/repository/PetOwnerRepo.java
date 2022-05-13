package com.yasin.petclinicdemo.repository;

import com.yasin.petclinicdemo.model.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepo extends JpaRepository<PetOwner, Long> {

}
