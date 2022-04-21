package com.ApiRestOdontologist.demo.Dto;

import com.ApiRestOdontologist.demo.Entities.Turn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologistDTO {

    private Integer id;
    private String name;
    private String lastname;
    private String licence;
}
