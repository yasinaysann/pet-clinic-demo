package com.yasin.petclinicdemo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "veterinarys")
@Builder
@Getter
@Setter

public class Veterinary extends BaseModel{

    public Veterinary(){
        super();
    }

}
