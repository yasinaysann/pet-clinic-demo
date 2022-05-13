package com.yasin.petclinicdemo.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pet_owners")
@EqualsAndHashCode
public class PetOwner extends BaseModel{

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pets_id")
    @OrderBy("name")
    private Set<Pet> pets = new LinkedHashSet<>();

}
