package com.example.SpringDataJPA.pagingAndsorting.util;

import com.example.SpringDataJPA.pagingAndsorting.dto.DomesticPetDTO;
import com.example.SpringDataJPA.pagingAndsorting.dto.PetDTO;
import com.example.SpringDataJPA.pagingAndsorting.dto.WildPetDTO;
import com.example.SpringDataJPA.pagingAndsorting.entity.DomesticPet;
import com.example.SpringDataJPA.pagingAndsorting.entity.Pet;
import com.example.SpringDataJPA.pagingAndsorting.entity.WildPet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {
    String UNSUPPORTED_PET_INSTANCE = "Unsupported pet instance: %s";
    default PetDTO petToPetDTO(Pet pet) {
        return switch (pet) {
            case DomesticPet domesticPet -> domesticPetToDomesticPetDTO(domesticPet);
            case WildPet wildPet -> wildPetToWildPetDTO(wildPet);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, pet.getClass()));
        };
    }
    @Mapping(target = "ownerDTO.petDTO", ignore = true)
    @Mapping(source = "owner", target = "ownerDTO")
    DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet);

    @Mapping(target = "ownerDTO.petDTO", ignore = true)
    @Mapping(source = "owner", target = "ownerDTO")
    WildPetDTO wildPetToWildPetDTO(WildPet wildPet);
}
