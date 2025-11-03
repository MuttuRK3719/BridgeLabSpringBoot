package com.example.SpringDataJPA.pagingAndsorting.service;

import com.example.SpringDataJPA.pagingAndsorting.dto.OwnerDTO;
import com.example.SpringDataJPA.pagingAndsorting.repository.OwnerRepository;
import com.example.SpringDataJPA.pagingAndsorting.util.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OwnerServiceImp implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public List<OwnerDTO> findAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }

    @Override
    public List<OwnerDTO> findAllSortedOwners(String sortingParameter, boolean sortDescending) {
        Direction direction = sortDescending ? Direction.DESC : Direction.ASC;
        Sort sort = Sort.by(direction, sortingParameter);
        return ownerRepository.findAll(sort)
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }
    @Override
    public List<OwnerDTO> findAllPaginatedOwners(int pageNumber, int numberOfRecordsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, numberOfRecordsPerPage);
        return ownerRepository.findAll(pageable)
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }

    @Override
    public List<OwnerDTO> findAllPaginatedAndSortedOwners(int pageNumber, int numberOfRecordsPerPage,
                                                          String sortingParameter, boolean sortDescending) {
        Direction direction = sortDescending ? Direction.DESC : Direction.ASC;
        Sort sort = Sort.by(direction, sortingParameter);
        Pageable pageable = PageRequest.of(pageNumber, numberOfRecordsPerPage, sort);
        return ownerRepository.findAll(pageable)
                .stream()
                .map(ownerMapper::ownerToOwnerDTO)
                .toList();
    }
}
