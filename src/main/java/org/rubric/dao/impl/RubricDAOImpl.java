package org.rubric.dao.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.Rubric;

import javax.persistence.*;
import java.util.List;

public class RubricDAOImpl implements CrudDAO<Rubric> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("rubric");

    @Override
    public void insert(Rubric rubric) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(rubric);
        transaction.commit();
        em.close();
    }

    @Override
    public Rubric findById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Rubric rubric = em.find(Rubric.class, id);
        transaction.commit();
        em.close();
        return rubric;
    }

    @Override
    public void update(Rubric rubric) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Rubric mergedRubric = em.merge(rubric);
        em.persist(mergedRubric);
        transaction.commit();
        em.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(Rubric.class, id));
        transaction.commit();
        em.close();
    }

    @Override
    public List<Rubric> findAll() {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Rubric> query = em.createQuery("SELECT r FROM Rubric r", Rubric.class);
        List<Rubric> rubrics = query.getResultList();
        transaction.commit();
        em.close();
        return rubrics;
    }
}
