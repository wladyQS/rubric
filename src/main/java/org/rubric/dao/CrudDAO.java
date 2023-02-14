package org.rubric.dao;

import java.util.List;

public interface CrudDAO<T> {
    void insert(T t);
    T findById(int id);
    void update(T t);
    void deleteById(int id);
    List<T> findAll();
}
