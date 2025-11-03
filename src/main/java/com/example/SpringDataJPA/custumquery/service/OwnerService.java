package com.example.SpringDataJPA.custumquery.service;

import com.example.SpringDataJPA.custumquery.dto.OwnerDTO;
import com.example.SpringDataJPA.custumquery.exceptions.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {
    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwnersByFirstNameInitials(String firstName);

    OwnerDTO findOwnerByPetId(int petId) throws OwnerNotFoundException;
    List<OwnerDTO> findByLastName(String lastName)throws OwnerNotFoundException;
}
