package org.rubric.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.rubric.dao.CrudDAO;
import org.rubric.dao.impl.RubricDAOImpl;
import org.rubric.domain.Rubric;
import org.rubric.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RubricServiceImpl implements CrudService<Rubric> {
    CrudDAO<Rubric> rubricDAO;

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
