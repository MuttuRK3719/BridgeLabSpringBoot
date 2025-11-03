package com.example.SpringDataJPA.example.service;

import com.example.SpringDataJPA.example.dto.PetDTO;
import com.example.SpringDataJPA.example.exceptions.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;

}
