package com.yasin.petclinicdemo.dto;

import com.yasin.petclinicdemo.model.Visit;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;

import java.util.List;

/**
 * used like request and response
 */
@Data
@Builder
public class PetDto {
    private String name;
    private String type;
    private LocalDate birthday;
    private List<Visit> visit;
}
