package com.ApiRestOdontologist.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private Date accessDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_address", referencedColumnName = "id")
    private Address address;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Turn> turns;
}
