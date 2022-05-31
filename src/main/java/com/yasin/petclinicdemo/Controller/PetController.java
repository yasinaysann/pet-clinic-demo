package com.yasin.petclinicdemo.Controller;


import com.sun.net.httpserver.Authenticator;
import com.yasin.petclinicdemo.model.Pet;
import com.yasin.petclinicdemo.repository.PetRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.OnError;
import java.util.List;


// TODO: request and response hatalarini çöz
// TODO: request = null
// TODO: response = null
// TODO: db = null
@RestController
@RequestMapping(value = "/api/v1/pet")
public class PetController {

    private final PetRepo petRepo;

    public PetController(PetRepo petRepo) {
        this.petRepo = petRepo;
    }


    @GetMapping("/getAll")
    public List<Pet>  getAll(){
        return petRepo.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Pet pet){
        petRepo.save(pet);
        return  ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }
}
