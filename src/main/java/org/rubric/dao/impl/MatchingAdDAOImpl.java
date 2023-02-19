package org.rubric.dao.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.domain.MatchingAd;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MatchingAdDAOImpl implements CrudDAO<MatchingAd> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(MatchingAd ad) {
        em.persist(ad);
    }

    @Override
    public MatchingAd findById(int id) {
        return em.find(MatchingAd.class, id);
    }

    @Override
    public void update(MatchingAd ad) {
        MatchingAd mergedAd = em.merge(ad);
        em.persist(mergedAd);
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(MatchingAd.class, id));
    }

    @Override
    public List<MatchingAd> findAll() {
        TypedQuery<MatchingAd> query = em.createQuery("SELECT a FROM MatchingAd a", MatchingAd.class);
        return query.getResultList();
    }
}
