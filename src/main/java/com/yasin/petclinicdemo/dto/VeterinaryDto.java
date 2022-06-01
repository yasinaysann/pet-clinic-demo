package com.yasin.petclinicdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Request and response operations this make class
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeterinaryDto implements Serializable {

    private String name;
    private String surname;
    private String phoneNumber;

    
}
