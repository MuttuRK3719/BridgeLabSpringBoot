package com.example.SpringDataJPA.custumquery.entity;

import com.example.SpringDataJPA.custumquery.enum1.Gender;
import com.example.SpringDataJPA.custumquery.enum1.PetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "pet_table")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true)
@Entity
public abstract class Pet extends Base {
    @Column(name = "name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PetType type;
    @OneToOne(mappedBy = "pet")
    private Owner owner;
}
