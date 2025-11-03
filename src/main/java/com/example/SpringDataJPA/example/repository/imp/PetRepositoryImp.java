package com.example.SpringDataJPA.example.repository.imp;

import com.example.SpringDataJPA.example.entity.Pet;
import com.example.SpringDataJPA.example.repository.PetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PetRepositoryImp implements PetRepository {
    @PersistenceUnit
    private EntityManagerFactory managerFactory;

    @Override
    public Optional<Pet> findById(int petId) {
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            Pet pet = entityManager.find(Pet.class, petId);
            return Optional.ofNullable(pet);
        }
    }
}
