package org.rubric.dao.impl;

import org.rubric.dao.AdDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AdDAOImpl implements AdDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Ad ad) {
        em.persist(ad);
    }

    @Override
    public Ad findById(int id) {
        return em.find(Ad.class, id);
    }

    @Override
    public void update(Ad ad) {
        Ad mergedAd = em.merge(ad);
        em.persist(mergedAd);
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(Ad.class, id));
    }

    @Override
    public List<Ad> findAll() {
        TypedQuery<Ad> query = em.createQuery("SELECT a FROM Ad a", Ad.class);
        return query.getResultList();
    }

    @Override
    public void deleteAll(Author author) {
        Query query = em.createQuery("DELETE FROM Ad a WHERE a.author = :author ");
        query.setParameter("author", author);
    }

    @Override
    public List<Ad> showAds(List<Integer> ids) {
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.rubric.id IN :ids", Ad.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }


}