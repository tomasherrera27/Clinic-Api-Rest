package com.ApiRestOdontologist.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity

public class Odontologist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String lastname;
    private String licence;
    @OneToMany(mappedBy = "odontologist", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private Set<Turn> turn;

    public Odontologist() {
    }

}
