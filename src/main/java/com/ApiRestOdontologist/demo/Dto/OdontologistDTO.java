package com.ApiRestOdontologist.demo.Dto;

import com.ApiRestOdontologist.demo.Entities.Turn;
import lombok.Data;

import java.util.Set;

@Data
public class OdontologistDTO {

    private Integer id;
    private String name;
    private String lastname;
    private String licence;
    private Set<Turn> turns;
}
