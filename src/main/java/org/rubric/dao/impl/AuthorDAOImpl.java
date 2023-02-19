package org.rubric.dao.impl;
import org.rubric.dao.CrudDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class AuthorDAOImpl implements CrudDAO<Author> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Author author) {
        em.persist(author);
    }

    @Override
    public Author findById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public void update(Author author) {
        Author mergedAuthor = em.merge(author);
        em.persist(mergedAuthor);
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(Ad.class, id));
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }
}
