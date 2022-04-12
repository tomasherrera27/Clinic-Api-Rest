package com.ApiRestOdontologist.demo.Repositories;

import com.ApiRestOdontologist.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
    public Patient findPatientByName(String name);
    public Patient findPatientByEmail(String email);
}
