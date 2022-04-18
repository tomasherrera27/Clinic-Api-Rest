package com.ApiRestOdontologist.demo.Dto;

import com.ApiRestOdontologist.demo.Entities.Address;
import com.ApiRestOdontologist.demo.Entities.Turn;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class PatientDTO {
    private Integer id;
    private String lastname;
    private String name;
    private String email;
    private String dni;
    private Date accessDate;
    private Address address;

    public PatientDTO(String lastname, String name, String email, String dni) {
        this.lastname = lastname;
        this.name = name;
        this.email = email;
        this.dni = dni;
    }
}

