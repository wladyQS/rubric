package org.rubric.dao.impl;

import org.rubric.dao.EmailDAO;
import org.rubric.domain.Ad;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EmailDAOImpl implements EmailDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void sendEmails(Ad ad) {
        //find author's emails
        List<String> emails = findEmails(ad);
        System.out.println(emails);
    }

    private List<String> findEmails(Ad ad) {
        TypedQuery<String> query = em.createQuery(
                "SELECT e.emailAddress " +
                        "FROM MatchingAd mad " +
                        "JOIN mad.author a " +
                        "JOIN a.email e " +
                        "JOIN mad.rubric r " +
                        "WHERE :ad_text LIKE CONCAT('%', mad.title, '%') AND r.name = :r_name " +
                        "AND :ad_price BETWEEN mad.priceFrom AND mad.priceTo", String.class);
        query.setParameter("ad_text", ad.getText());
        query.setParameter("r_name", ad.getRubric().getName());
        query.setParameter("ad_price", ad.getPrice());
        return query.getResultList();
    }

}

/**
 * Mads:
 * rubric - Car, priceFrom - 500 priceTo - 1000, title - "Bmw", FK_author = 1, Author -> Email
 * rubric - Car, priceFrom - 300 priceTo - 1000, FK_author = 2, title - "Bmw", Author -> Email
 * <p>
 * Ad:
 * rubric - Car, price - 500, text - "Bmw"
 * <p>
 * title mad - car
 * ad text - I want to sell new car
 */
