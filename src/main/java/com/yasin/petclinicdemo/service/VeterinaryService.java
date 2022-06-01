package com.yasin.petclinicdemo.service;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.dto.converter.VeterinaryConverter;
import com.yasin.petclinicdemo.exception.NotFoundException;
import com.yasin.petclinicdemo.model.Veterinary;
import com.yasin.petclinicdemo.repository.VeterinaryRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeterinaryService{


    private final VeterinaryRepo veterinaryRepo;
    private final VeterinaryConverter veterinaryConverter;

    public VeterinaryService(VeterinaryRepo veterinaryRepo, VeterinaryConverter veterinaryConverter) {
        this.veterinaryRepo = veterinaryRepo;
        this.veterinaryConverter = veterinaryConverter;
    }

    public List<VeterinaryDto> getAll(){

        return veterinaryConverter.convertToDto(veterinaryRepo.findAll());

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
        return veterinaryConverter.convertToDto(veterinaryRepo.findByName(nameOrSurname));
    }
    public List<Veterinary> getAllByName(String nameOrSurname){
        return veterinaryRepo.findAllByName(nameOrSurname);
    }


    public void deleteByName(String name){
        //return veterinaryConvert.convertToDto(veterinaryRepo.deleteByName(name));

        veterinaryRepo.delete(veterinaryRepo.findByName(name));

    }

    public void add(VeterinaryDto veterinary){
        /*
        VeterinaryDto veterinaryDto = VeterinaryDto.builder()
                .name(veterinary.getName())
                .surname(veterinary.getSurname())
                .phoneNumber(veterinary.getPhoneNumber())
                .build();

         */
        veterinaryRepo.save(veterinaryConverter.convertDtoToEntity(veterinary));


        //veterinaryRepo.save(veterinary);
    }



    @Transactional
    public void update(Long id, VeterinaryDto veterinary){
        veterinaryRepo.findById(id).map(veterinary1 ->{

            veterinary1.setName(veterinary.getName());
            veterinary1.setSurname(veterinary.getSurname());
            veterinary1.setPhoneNumber(veterinary.getPhoneNumber());
            return veterinaryRepo.save(veterinary1);
        }).orElseThrow(() -> new NotFoundException("Data not found"));


    }
}
