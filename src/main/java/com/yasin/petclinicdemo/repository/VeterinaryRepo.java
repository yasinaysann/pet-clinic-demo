package com.yasin.petclinicdemo.repository;

import com.yasin.petclinicdemo.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface VeterinaryRepo extends JpaRepository<Veterinary, Long> {

    Optional<Veterinary> getByName(String name);

    Veterinary findByName(String name);
    List<Veterinary> findAllByName(String nameOrSurname);



    // burayi coz
    //public Veterinary findByNameOrSurname(String nameAndSurname);


}
