package com.yasin.petclinicdemo.dto.converter;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.model.Veterinary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeterinaryConverter {


    public VeterinaryDto convertToDto(Veterinary veterinary){
        return VeterinaryDto.builder()
                .name(veterinary.getName())
                .surname(veterinary.getSurname())
                .phoneNumber(veterinary.getPhoneNumber())
                .build();
    }

    public List<VeterinaryDto> convertToDto(List<Veterinary> veterinary){
        List<VeterinaryDto> veterinaryDtoList = veterinary.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return veterinaryDtoList;

    }






    public Veterinary convertDtoToEntity(VeterinaryDto veterinaryDto){
        Veterinary veterinary = new Veterinary();
        veterinary.setName(veterinaryDto.getName());
        veterinary.setSurname(veterinaryDto.getSurname());
        veterinary.setPhoneNumber(veterinaryDto.getPhoneNumber());
        return veterinary;

    }



}
