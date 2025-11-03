package com.example.SpringDataJPA.example.util;

import com.example.SpringDataJPA.example.dto.DomesticPetDTO;
import com.example.SpringDataJPA.example.dto.OwnerDTO;
import com.example.SpringDataJPA.example.dto.PetDTO;
import com.example.SpringDataJPA.example.dto.WildPetDTO;
import com.example.SpringDataJPA.example.entity.DomesticPet;
import com.example.SpringDataJPA.example.entity.Owner;
import com.example.SpringDataJPA.example.entity.Pet;
import com.example.SpringDataJPA.example.entity.WildPet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OwnerMapper {
    String UNSUPPORTED_PET_INSTANCE = "Unsupported pet instance: %s";

    @Mapping(source = "petDTO", target = "pet")
    Owner ownerDTOToOwner(OwnerDTO ownerDTO);

    default Pet petDTOToPet(PetDTO petDTO) {
        return switch (petDTO) {
            case DomesticPetDTO domesticPetDTO -> domesticPetDTOToDomesticPet(domesticPetDTO);
            case WildPetDTO wildPetDTO -> wildPetDTOToWildPet(wildPetDTO);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, petDTO.getClass()));
        };
    }

    @Mapping(target = "owner", ignore = true)
    DomesticPet domesticPetDTOToDomesticPet(DomesticPetDTO domesticPetDTO);

    @Mapping(target = "owner", ignore = true)
    WildPet wildPetDTOToWildPet(WildPetDTO wildPetDTO);

    @Mapping(source = "pet", target = "petDTO")
    OwnerDTO ownerToOwnerDTO(Owner owner);

    default PetDTO petToPetDTO(Pet pet) {
        return switch (pet) {
            case DomesticPet domesticPet -> domesticPetToDomesticPetDTO(domesticPet);
            case WildPet wildPet -> wildPetToWildPetDTO(wildPet);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, pet.getClass()));
        };
    }

    @Mapping(target = "ownerDTO", ignore = true)
    DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet);

    @Mapping(target = "ownerDTO", ignore = true)
    WildPetDTO wildPetToWildPetDTO(WildPet wildPet);
}
