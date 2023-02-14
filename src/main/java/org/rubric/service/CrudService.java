package org.rubric.service;

import java.util.List;

public interface CrudService<T> {
    void save(T t);
    T findById(int id);
    void update(T t);
    void deleteById(int id);
    List<T> findAll();
}
