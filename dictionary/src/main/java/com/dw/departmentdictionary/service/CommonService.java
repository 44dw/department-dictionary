package com.dw.departmentdictionary.service;

import java.util.List;

public interface CommonService<T> {
    List<T> getAll();
    T getOneById(Integer id);
    T save(T entity);
    T update(T entity);
    void deleteById(Integer id);
}
