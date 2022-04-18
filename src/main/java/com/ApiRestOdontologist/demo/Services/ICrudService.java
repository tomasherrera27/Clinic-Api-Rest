package com.ApiRestOdontologist.demo.Services;

import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface ICrudService<T> {
    T findById(Integer id) throws ResourceNotFoundException;
    T Create(T t);
    void deleteById(Integer id) throws ResourceNotFoundException;
    T update(T t);
    List<T> findAll();
    Set<T> listTurns();
}
