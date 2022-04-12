package com.ApiRestOdontologist.demo.Repositories;

import com.ApiRestOdontologist.demo.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
