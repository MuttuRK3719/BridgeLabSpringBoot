package com.example.SpringDataJPA.custumquery.service.imp;

import com.example.SpringDataJPA.custumquery.dto.PetDTO;
import com.example.SpringDataJPA.custumquery.exceptions.PetNotFoundException;
import com.example.SpringDataJPA.custumquery.repository.PetRepository;
import com.example.SpringDataJPA.custumquery.service.PetService;
import com.example.SpringDataJPA.custumquery.util.PetMapper;
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
