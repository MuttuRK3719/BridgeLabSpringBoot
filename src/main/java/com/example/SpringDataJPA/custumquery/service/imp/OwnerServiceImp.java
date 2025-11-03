package com.example.SpringDataJPA.custumquery.service.imp;

import com.example.SpringDataJPA.custumquery.dto.OwnerDTO;
import com.example.SpringDataJPA.custumquery.exceptions.OwnerNotFoundException;
import com.example.SpringDataJPA.custumquery.repository.OwnerRepository;
import com.example.SpringDataJPA.custumquery.service.OwnerService;
import com.example.SpringDataJPA.custumquery.util.OwnerMapper;
import com.example.SpringDataJPA.custumquery.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OwnerServiceImp implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    @Value("${owner.not.found}")
    private String ownerNotFound;
    @Value("${owner.pet.not.found}")
    private String ownerPetNotFound;

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(ownerId);
        if (Objects.isNull(owner)) {
            throw new OwnerNotFoundException(String.format(ownerNotFound, ownerId));
        }
        return ownerMapper.ownerToOwnerDTO(owner);
    }

    @Override
    public List<OwnerDTO> findAllOwnersByFirstNameInitials(String firstName) {
        return ownerRepository.findByFirstNameStartsWith(firstName)
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }

    @Override
    public OwnerDTO findOwnerByPetId(int petId) throws OwnerNotFoundException {
        return ownerRepository.findByPet_Id(petId)
                .map(ownerMapper::ownerToOwnerDTO)
                .orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, petId)));

    }

    @Override
    public List<OwnerDTO> findByLastName(String lastName) throws OwnerNotFoundException {
        return ownerRepository.findByLastNameStartsWith(lastName)
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }
}
