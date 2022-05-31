package com.yasin.petclinicdemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "veterinarys")

@Getter
@Setter

public class Veterinary extends BaseModel{



    public Veterinary(){
        super();
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pet> pets = new ArrayList<>();

}
