package com.example.SpringDataJPA.example.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Table(name = "domestic_pet_table")
@ToString(callSuper = true)
@Entity
public class DomesticPet extends Pet {

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthDate;

}