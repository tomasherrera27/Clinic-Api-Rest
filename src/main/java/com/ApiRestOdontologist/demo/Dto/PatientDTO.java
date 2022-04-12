package com.ApiRestOdontologist.demo.Dto;

import com.ApiRestOdontologist.demo.Entities.Address;
import com.ApiRestOdontologist.demo.Entities.Turn;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class PatientDTO {
    private Integer id;
    private String lastname;
    private String name;
    private String email;
    private String dni;
    private Date accessDate;
    private Address address;
    private Set<Turn> turns;
}

