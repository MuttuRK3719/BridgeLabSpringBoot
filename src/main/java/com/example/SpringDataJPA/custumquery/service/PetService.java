package com.example.SpringDataJPA.custumquery.service;

import com.example.SpringDataJPA.custumquery.dto.PetDTO;
import com.example.SpringDataJPA.custumquery.exceptions.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
