package com.yasin.petclinicdemo.dto.convert;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.model.Veterinary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeterinaryConvert {


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

}
