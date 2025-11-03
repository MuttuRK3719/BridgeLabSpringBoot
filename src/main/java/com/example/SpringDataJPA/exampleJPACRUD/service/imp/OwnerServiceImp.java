package com.example.SpringDataJPA.exampleJPACRUD.service.imp;

import com.example.SpringDataJPA.exampleJPACRUD.dto.OwnerDTO;
import com.example.SpringDataJPA.exampleJPACRUD.entity.Owner;
import com.example.SpringDataJPA.exampleJPACRUD.exceptions.OwnerNotFoundException;
import com.example.SpringDataJPA.exampleJPACRUD.repository.OwnerRepository;
import com.example.SpringDataJPA.exampleJPACRUD.service.OwnerService;
import com.example.SpringDataJPA.exampleJPACRUD.util.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerServiceImp implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    @Value("${owner.not.found}")
    private String ownerNotFound;

    @Override
    public void saveOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.ownerDTOToOwner(ownerDTO);
        ownerRepository.save(owner);
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId)
                .map(ownerMapper::ownerToOwnerDTO)
                .orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        Owner owner=ownerRepository.findById(ownerId).orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
        owner.getPet().setName(petName);
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        if (optionalOwner.isEmpty()) {
            throw new OwnerNotFoundException(String.format(ownerNotFound, ownerId));
        } else {
            ownerRepository.deleteById(ownerId);
        }
    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }
}
