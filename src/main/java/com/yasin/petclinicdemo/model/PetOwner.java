package com.yasin.petclinicdemo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pet_owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetOwner extends BaseModel{

    @Column(name = "address")
    private String address;

}
