package com.example.SpringDataJPA.example.repository.imp;

import com.example.SpringDataJPA.example.entity.Owner;
import com.example.SpringDataJPA.example.entity.Pet;
import com.example.SpringDataJPA.example.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class OwnerRepositoryImp implements OwnerRepository {
    @PersistenceUnit
    private EntityManagerFactory managerFactory;

    @Override
    public void save(Owner owner) {
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(owner);
            transaction.commit();
        }
    }

    @Override
    public Optional<Owner> findById(int ownerId) {
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            Owner owner = entityManager.find(Owner.class, ownerId);
            if (Objects.nonNull(owner)) {
                Pet pet = Hibernate.unproxy(owner.getPet(), Pet.class);
                owner.setPet(pet);
            }
            return Optional.ofNullable(owner);
        }
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Owner owner = entityManager.find(Owner.class, ownerId);
            if (Objects.nonNull(owner)) {
                owner.getPet().setName(petName);
            }
            transaction.commit();
        }
    }

    @Override
    public void deleteById(int ownerId) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Owner owner = entityManager.find(Owner.class, ownerId);
        if (Objects.nonNull(owner)) {
            entityManager.remove(owner);
        }
        transaction.commit();
    }

    @Override
    public List<Owner> findAll() {
        String jpql = "SELECT o FROM Owner o JOIN FETCH o.pet";
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            return entityManager.createQuery(jpql, Owner.class).getResultList();
        }
    }
}
