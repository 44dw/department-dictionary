package com.dw.departmentdictionary.resource;

import java.util.List;

public interface CommonResource<T> {
    List<T> getAll();
    T getOneById(Integer id);
    T save(T entity);
    T update(Integer id, T entity);
    void deleteById(Integer id);
}
