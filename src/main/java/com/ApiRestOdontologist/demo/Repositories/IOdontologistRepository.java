package com.ApiRestOdontologist.demo.Repositories;

import com.ApiRestOdontologist.demo.Entities.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologistRepository extends JpaRepository<Odontologist,Integer> {

}
