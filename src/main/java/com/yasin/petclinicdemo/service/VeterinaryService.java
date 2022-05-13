package com.yasin.petclinicdemo.service;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.dto.convert.VeterinaryConvert;
import com.yasin.petclinicdemo.exception.NotFoundException;
import com.yasin.petclinicdemo.model.Veterinary;
import com.yasin.petclinicdemo.repository.VeterinaryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinaryService {


    private final VeterinaryRepo veterinaryRepo;
    //private VeterinaryConvert veterinaryConvert;

    public VeterinaryService( VeterinaryRepo veterinaryRepo) {
        this.veterinaryRepo = veterinaryRepo;
    }

    public List<Veterinary> getAll(){
        return veterinaryRepo.findAll();
    }

    public Veterinary getById(Long id) {
        return veterinaryRepo.findById(id).orElseThrow(()->new NotFoundException("Data Bulunamadi"));
        //return veterinaryRepo.getById(id);
    }

    public VeterinaryDto getByName(String nameOrSurname){
        return veterinaryConvert.convertToDto(veterinaryRepo.findByName(nameOrSurname));
    }
    public List<Veterinary> getAllByName(String nameOrSurname){
        return veterinaryRepo.findAllByName(nameOrSurname);
    }

    public void deleteByName(String name){
        veterinaryRepo.delete(veterinaryRepo.findByName(name));
    }

    public void add(Veterinary veterinary){
        veterinaryRepo.save(veterinary);
    }


}
