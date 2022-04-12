package com.ApiRestOdontologist.demo.Repositories;

import com.ApiRestOdontologist.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
    public Patient findPatientByName(String name);
    @Query("select p from Patient p where p.email like %?1%")
    public Patient findPatientByEmail(String email);
}
