package com.ApiRestOdontologist.demo.Services;

import java.util.List;

public interface ICrudService<T> {
    T findById(Integer id);
    T Create(T t);
    void deleteById(Integer id);
    T update(T t);
    List<T> findAll();
}
