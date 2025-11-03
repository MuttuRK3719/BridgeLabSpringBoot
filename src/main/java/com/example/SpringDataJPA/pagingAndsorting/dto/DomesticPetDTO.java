package com.example.SpringDataJPA.pagingAndsorting.dto;


import com.example.SpringDataJPA.pagingAndsorting.enum1.Gender;
import com.example.SpringDataJPA.pagingAndsorting.enum1.PetType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class DomesticPetDTO extends PetDTO {
    private LocalDate birthDate;

    @Builder
    public DomesticPetDTO(int id, String name, Gender gender, PetType type, OwnerDTO ownerDTO, LocalDate birthDate) {
        super(id, name, gender, type, ownerDTO);
        this.birthDate = birthDate;
    }
}
