package com.yasin.petclinicdemo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pet_owners")
@Getter
@Setter
public class PetOwner extends BaseModel{

    @Column(name = "address")
    private String address;

   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //    @OrderBy("name")
    //    private List<Pet> pets =new ArrayList<>();

}
