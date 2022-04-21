package com.ApiRestOdontologist.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private Date accessDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_address", referencedColumnName = "id")
    private Address address;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Turn> turns = new HashSet<>();
}
