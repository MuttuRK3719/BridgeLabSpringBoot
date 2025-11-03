package com.example.SpringDataJPA.pagingAndsorting.service;

import com.example.SpringDataJPA.pagingAndsorting.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    List<OwnerDTO> findAllOwners();

    List<OwnerDTO> findAllSortedOwners(String sortingParameter, boolean sortDescending);

    List<OwnerDTO> findAllPaginatedOwners(int pageNumber, int numberOfRecordsPerPage);

    List<OwnerDTO> findAllPaginatedAndSortedOwners(int pageNumber, int numberOfRecordsPerPage,
                                                   String sortingParameter, boolean sortDescending);
}
