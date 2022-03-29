package com.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGeneralRepository<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    void save(T t);

    void remove(Long id);

    void remove(T t);
}
