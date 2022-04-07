package com.ApiRestOdontologist.demo.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Turn {
    @Id
    private Integer id;
    private Date date;
    private Time hour;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_odontologist", nullable = false)
    private Odontologist odontologist;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_patient", nullable = false)
    private Patient patient;

}
