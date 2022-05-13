package com.yasin.petclinicdemo.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "veterinarys")
public class Veterinary extends BaseModel{

    public Veterinary() {
        super();
    }

}
