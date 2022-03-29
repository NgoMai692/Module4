package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findOne(Long id);

    void save(T t);

    void remove(T t);

    void remove(Long id);

}