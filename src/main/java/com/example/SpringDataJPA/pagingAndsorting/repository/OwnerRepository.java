package com.example.SpringDataJPA.pagingAndsorting.repository;

import com.example.SpringDataJPA.pagingAndsorting.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
