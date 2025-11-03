package com.example.SpringDataJPA.custumquery.repository;

import com.example.SpringDataJPA.custumquery.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findById(int ownerId);

    List<Owner> findByFirstNameStartsWith(String firstName);

    Optional<Owner> findByPet_Id(int petId);

    List<Owner> findByLastNameStartsWith(String lastName);
}
