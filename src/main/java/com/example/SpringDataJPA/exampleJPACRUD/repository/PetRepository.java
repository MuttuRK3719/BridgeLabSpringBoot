package com.example.SpringDataJPA.exampleJPACRUD.repository;

import com.example.SpringDataJPA.exampleJPACRUD.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Integer> {

}
