package com.ApiRestOdontologist.demo.Dto;

import com.ApiRestOdontologist.demo.Entities.Odontologist;
import com.ApiRestOdontologist.demo.Entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnDTO {
    private Integer id;
    private Date date;
    private Time hour;
    private Odontologist odontologist;
    private Patient patient;
}
