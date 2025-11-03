package com.example.SpringDataJPA.custumquery.dto;


import com.example.SpringDataJPA.custumquery.enum1.Gender;
import com.example.SpringDataJPA.custumquery.enum1.PetType;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Setter
@Getter
public abstract class PetDTO {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private Gender gender;
    private PetType type;
    private OwnerDTO ownerDTO;
}
