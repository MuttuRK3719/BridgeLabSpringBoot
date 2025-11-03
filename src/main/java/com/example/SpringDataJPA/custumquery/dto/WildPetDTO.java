package com.example.SpringDataJPA.custumquery.dto;

import com.example.SpringDataJPA.custumquery.enum1.Gender;
import com.example.SpringDataJPA.custumquery.enum1.PetType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class WildPetDTO extends PetDTO {
    private String birthPlace;
    @Builder
    public WildPetDTO(int id, String name, Gender gender, PetType type, OwnerDTO ownerDTO, String birthPlace) {
        super(id, name, gender, type, ownerDTO);
        this.birthPlace = birthPlace;
    }
}
