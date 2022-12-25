package me.zakaria.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOwnerRequestDTO {

    private String nom;
    private Date dateNaissance;
    private String email;


}
