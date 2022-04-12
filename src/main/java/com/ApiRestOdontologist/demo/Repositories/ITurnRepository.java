package com.ApiRestOdontologist.demo.Repositories;

import com.ApiRestOdontologist.demo.Entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Integer> {
}
