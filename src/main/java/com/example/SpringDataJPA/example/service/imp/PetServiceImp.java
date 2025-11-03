package com.example.SpringDataJPA.example.service.imp;

import com.example.SpringDataJPA.example.dto.PetDTO;
import com.example.SpringDataJPA.example.exceptions.PetNotFoundException;
import com.example.SpringDataJPA.example.repository.PetRepository;
import com.example.SpringDataJPA.example.service.PetService;
import com.example.SpringDataJPA.example.util.PetMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetServiceImp implements PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;
    @Value("${pet.not.found}")
    private String petNotFound;

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId)
                .map(petMapper::petToPetDTO)
                .orElseThrow(() -> new PetNotFoundException(String.format(petNotFound, petId)));
    }
}
