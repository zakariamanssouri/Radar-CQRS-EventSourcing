package me.zakaria.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehiculeRequestDTO {

    private String immatriculation;
    private String marque;
    private int puissance;
    private String modele;
    private String ownerId;

}
