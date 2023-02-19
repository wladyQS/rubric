package org.rubric.dao.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.domain.Rubric;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class RubricDAOImpl implements CrudDAO<Rubric> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Rubric rubric) {
        em.persist(rubric);
    }

    @Override
    public Rubric findById(int id) {
        return em.find(Rubric.class, id);
    }

    @Override
    public void update(Rubric rubric) {
        Rubric mergedRubric = em.merge(rubric);
        em.persist(mergedRubric);
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(Rubric.class, id));
    }

    @Override
    public List<Rubric> findAll() {
        TypedQuery<Rubric> query = em.createQuery("SELECT r FROM Rubric r", Rubric.class);
        return query.getResultList();
    }
}
