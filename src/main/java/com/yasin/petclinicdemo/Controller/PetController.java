package com.yasin.petclinicdemo.Controller;


import com.sun.net.httpserver.Authenticator;
import com.yasin.petclinicdemo.dto.PetDto;
import com.yasin.petclinicdemo.dto.converter.PetConverter;
import com.yasin.petclinicdemo.model.Pet;
import com.yasin.petclinicdemo.repository.PetRepo;
import com.yasin.petclinicdemo.service.PetService;
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



    private final PetService petService;
    private final PetConverter petConverter;

    public PetController(PetService petService, PetConverter petConverter) {
        this.petService = petService;
        this.petConverter = petConverter;
    }

    @GetMapping(value = "/getAll")
    public List<PetDto>  getAll(){
        return petService.getAll();
    }


    @PostMapping(value = "/add")
    public HttpStatus add(@RequestBody PetDto petDto){
        if (petService.add(petDto)){
            return new ResponseEntity<>(HttpStatus.OK).getStatusCode();
        }return new ResponseEntity<>(HttpStatus.NO_CONTENT).getStatusCode();

    }
}
