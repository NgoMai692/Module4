package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    T findOne(Long id);

    void save(T t);

    void remove(T t);

    void remove(Long id);

}