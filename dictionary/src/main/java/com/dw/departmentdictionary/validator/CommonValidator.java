package com.dw.departmentdictionary.validator;

public interface CommonValidator<T> {
    default void validateCreation(T entity) {};
    default void validateDeletion(T entity) {};
}
