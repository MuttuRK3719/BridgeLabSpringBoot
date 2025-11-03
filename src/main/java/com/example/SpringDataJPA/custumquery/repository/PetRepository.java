package com.example.SpringDataJPA.custumquery.repository;

import com.example.SpringDataJPA.custumquery.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet,Integer> {
    Optional<Pet> findById(int petId);
}
