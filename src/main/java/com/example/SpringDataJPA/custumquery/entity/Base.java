package com.example.SpringDataJPA.custumquery.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class Base {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq_gen")
    @SequenceGenerator(
            name = "owner_seq_gen",
            sequenceName = "owner_seq",
            allocationSize = 1
    )
    @Id
    private int id;
}
