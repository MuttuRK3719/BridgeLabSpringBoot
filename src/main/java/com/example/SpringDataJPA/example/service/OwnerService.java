package com.example.SpringDataJPA.example.service;

import com.example.SpringDataJPA.example.dto.OwnerDTO;
import com.example.SpringDataJPA.example.exceptions.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {
    void saveOwner(OwnerDTO ownerDTO);

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwners();
}
