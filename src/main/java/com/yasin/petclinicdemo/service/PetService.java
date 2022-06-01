package com.yasin.petclinicdemo.service;

import com.yasin.petclinicdemo.dto.PetDto;
import com.yasin.petclinicdemo.dto.converter.PetConverter;
import com.yasin.petclinicdemo.repository.PetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepo petRepo;
    private final PetConverter petConverter;

    public PetService(PetRepo petRepo, PetConverter petConverter) {
        this.petRepo = petRepo;
        this.petConverter = petConverter;
    }

    public List<PetDto> getAll(){
        return petConverter.convertToDto(petRepo.findAll());
    }

    public boolean add(PetDto petDto){
        if (petDto != null){
            petRepo.save(petConverter.convertDtoToEntity(petDto));
            return true;
        }
        return false;


    }


}
