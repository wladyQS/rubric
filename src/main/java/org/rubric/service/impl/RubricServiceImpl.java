package org.rubric.service.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.dao.impl.RubricDAOImpl;
import org.rubric.domain.Rubric;
import org.rubric.service.CrudService;

import java.util.List;

public class RubricServiceImpl implements CrudService<Rubric> {
    private final CrudDAO<Rubric> rubricDAO;

    public RubricServiceImpl() {
        rubricDAO = new RubricDAOImpl();
    }


    @Override
    public void save(Rubric rubric) {
        rubricDAO.insert(rubric);
    }

    @Override
    public Rubric findById(int id) {
        return rubricDAO.findById(id);
    }

    @Override
    public void update(Rubric rubric) {
        rubricDAO.update(rubric);
    }

    @Override
    public void deleteById(int id) {
        rubricDAO.deleteById(id);
    }

    @Override
    public List<Rubric> findAll() {
        return rubricDAO.findAll();
    }
}
