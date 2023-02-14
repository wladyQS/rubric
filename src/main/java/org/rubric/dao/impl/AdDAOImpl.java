package org.rubric.dao.impl;

import org.rubric.dao.AdDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.Author;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class AdDAOImpl implements AdDAO {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("rubric");

    @Override
    public void insert(Ad ad) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ad);
        transaction.commit();
        em.close();
    }

    @Override
    public Ad findById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Ad ad = em.find(Ad.class, id);
        transaction.commit();
        em.close();
        return ad;
    }

    @Override
    public void update(Ad ad) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Ad mergedAd = em.merge(ad);
        em.persist(mergedAd);
        transaction.commit();
        em.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(Ad.class, id));
        transaction.commit();
        em.close();
    }

    @Override
    public List<Ad> findAll() {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query = em.createQuery("SELECT a FROM Ad a", Ad.class);
        List<Ad> ads = query.getResultList();
        transaction.commit();
        em.close();
        return ads;
    }

    @Override
    public void deleteAll(Author author) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Ad a WHERE a.author = :author ");
        query.setParameter("author", author);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    @Override
    public List<Ad> showAds(List<Integer> ids) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.rubric.id IN :ids", Ad.class);
        query.setParameter("ids", ids);
        List<Ad> ads = query.getResultList();
        transaction.commit();
        return ads;
    }


}