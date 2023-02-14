package org.rubric.dao.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.MatchingAd;

import javax.persistence.*;
import java.util.List;

public class MatchingAdDAOImpl implements CrudDAO<MatchingAd> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("rubric");

    @Override
    public void insert(MatchingAd ad) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ad);
        transaction.commit();
        em.close();
    }

    @Override
    public MatchingAd findById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        MatchingAd ad = em.find(MatchingAd.class, id);
        transaction.commit();
        em.close();
        return ad;
    }

    @Override
    public void update(MatchingAd ad) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        MatchingAd mergedAd = em.merge(ad);
        em.persist(mergedAd);
        transaction.commit();
        em.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(MatchingAd.class, id));
        transaction.commit();
        em.close();
    }

    @Override
    public List<MatchingAd> findAll() {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<MatchingAd> query = em.createQuery("SELECT a FROM MatchingAd a", MatchingAd.class);
        List<MatchingAd> matchingAds = query.getResultList();
        transaction.commit();
        em.close();
        return matchingAds;
    }
}
