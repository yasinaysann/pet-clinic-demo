package com.yasin.petclinicdemo.service;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.dto.convert.VeterinaryConvert;
import com.yasin.petclinicdemo.exception.NotFoundException;
import com.yasin.petclinicdemo.model.Veterinary;
import com.yasin.petclinicdemo.repository.VeterinaryRepo;
import com.yasin.petclinicdemo.request.RequestVeterinary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VeterinaryService{


    private final VeterinaryRepo veterinaryRepo;
    private final VeterinaryConvert veterinaryConvert;

    public VeterinaryService(VeterinaryRepo veterinaryRepo, VeterinaryConvert veterinaryConvert) {
        this.veterinaryRepo = veterinaryRepo;
        this.veterinaryConvert = veterinaryConvert;
    }

    public List<VeterinaryDto> getAll(){

        return veterinaryConvert.convertToDto(veterinaryRepo.findAll());

    }
    /*
        todo
        return VeterinaryDto reduce
     */
    public Veterinary getById(Long id) {
        return veterinaryRepo.findById(id).orElseThrow(()->new NotFoundException("Data Bulunamadi"));
        //return veterinaryRepo.getById(id);
    }

    public VeterinaryDto getByName(String nameOrSurname){
        Veterinary veterinary = veterinaryRepo.findByName(nameOrSurname);
        if (veterinary == null){
            throw new NotFoundException("Data bulunamadı !!");
        }
        return veterinaryConvert.convertToDto(veterinaryRepo.findByName(nameOrSurname));
    }
    public List<Veterinary> getAllByName(String nameOrSurname){
        return veterinaryRepo.findAllByName(nameOrSurname);
    }


    public void deleteByName(String name){
        //return veterinaryConvert.convertToDto(veterinaryRepo.deleteByName(name));

        veterinaryRepo.delete(veterinaryRepo.findByName(name));

    }

    public void add(RequestVeterinary veterinary){
        /*
        VeterinaryDto veterinaryDto = VeterinaryDto.builder()
                .name(veterinary.getName())
                .surname(veterinary.getSurname())
                .phoneNumber(veterinary.getPhoneNumber())
                .build();

         */
        veterinaryRepo.save(veterinaryConvert.convertToEntity(veterinary));


        //veterinaryRepo.save(veterinary);
    }



    public void update(Long id, RequestVeterinary veterinary){
        veterinaryRepo.findById(id).map(veterinary1 ->{

            veterinary1.setName(veterinary.getName());
            veterinary1.setSurname(veterinary.getSurname());
            veterinary1.setPhoneNumber(veterinary.getPhoneNumber());
            return veterinaryRepo.save(veterinary1);
        }).orElseThrow(() -> new NotFoundException("Data not found"));


    }
}
