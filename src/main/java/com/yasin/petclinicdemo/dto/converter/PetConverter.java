package com.yasin.petclinicdemo.dto.converter;


import com.yasin.petclinicdemo.dto.PetDto;
import com.yasin.petclinicdemo.model.Pet;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetConverter {

    public PetDto convertToDto(Pet pet){
        return PetDto.builder()
                .name(pet.getName())
                .birthday(pet.getBirthDate())
                .type(pet.getType())
                .visit(pet.getVisit())
                .build();
    }
    public List<PetDto> convertToDto(List<Pet> pets){
        /**
         * List<PetDto> petDto = pets.stream()
         *                 .map(this::convertToDto)
         *                 .collect(Collectors.toList());
         *         return petDto;
         */
        return pets.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public Pet convertDtoToEntity(PetDto petDto){
        return Pet.builder()
                .name(petDto.getName())
                .birthDate(petDto.getBirthday())
                .type(petDto.getType())
                .visit(petDto.getVisit())
                .build();
    }



}
