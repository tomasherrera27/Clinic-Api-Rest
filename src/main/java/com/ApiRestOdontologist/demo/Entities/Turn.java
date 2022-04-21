package com.ApiRestOdontologist.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Time hour;
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="id_odontologist")
    private Odontologist odontologist;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="id_patient", referencedColumnName = "id", nullable = false)
    private Patient patient;

}
