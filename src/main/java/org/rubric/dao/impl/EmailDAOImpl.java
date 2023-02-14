package org.rubric.dao.impl;

import org.rubric.dao.EmailDAO;
import org.rubric.domain.Ad;
import org.rubric.domain.MatchingAd;
import org.rubric.service.CrudService;
import org.rubric.service.impl.MatchingAdServiceImpl;

import javax.persistence.*;
import java.util.List;

public class EmailDAOImpl implements EmailDAO {
    private final CrudService matchingAdService;
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("rubric");

    public EmailDAOImpl() {
        this.matchingAdService = new MatchingAdServiceImpl();
    }

    @Override
    public void sendEmails(Ad ad) {
        //find author's emails
        List<String> emails = findEmails(ad);
        System.out.println(emails);
    }

    private List<String> findEmails(Ad ad) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

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

        List<String> emails = query.getResultList();

        transaction.commit();
        em.close();
        return emails;
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
