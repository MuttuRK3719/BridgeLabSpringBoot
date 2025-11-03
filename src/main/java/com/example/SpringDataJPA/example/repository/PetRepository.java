package com.example.SpringDataJPA.example.repository;

import com.example.SpringDataJPA.example.entity.Pet;

import java.util.Optional;

public interface PetRepository {

    Optional<Pet> findById(int petId);
}
