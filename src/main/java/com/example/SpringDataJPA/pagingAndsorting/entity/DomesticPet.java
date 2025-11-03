package com.example.SpringDataJPA.pagingAndsorting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@Table(name = "domestic_pet_table")
@ToString(callSuper = true)
@Entity
public class DomesticPet extends Pet {

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthDate;

}