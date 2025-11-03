package com.example.SpringDataJPA.pagingAndsorting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Table(name = "wild_pet_table")
@Entity
@ToString(callSuper = true)
public class WildPet extends Pet {

    @Column(name = "place_of_birth", nullable = false)
    private String birthPlace;

}