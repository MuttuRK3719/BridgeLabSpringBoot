package com.example.SpringDataJPA.exampleJPACRUD.service;

import com.example.SpringDataJPA.exampleJPACRUD.dto.PetDTO;
import com.example.SpringDataJPA.exampleJPACRUD.exceptions.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;

}
