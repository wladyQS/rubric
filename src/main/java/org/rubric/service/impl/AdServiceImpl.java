package org.rubric.service.impl;

import org.rubric.dao.AdDAO;
import org.rubric.dao.EmailDAO;
import org.rubric.dao.impl.AdDAOImpl;
import org.rubric.dao.impl.EmailDAOImpl;
import org.rubric.domain.Ad;
import org.rubric.domain.Author;
import org.rubric.service.AdService;

import java.util.List;

public class AdServiceImpl implements AdService {
    private final AdDAO adDAO;
    private final EmailDAO emailDAO;

    public AdServiceImpl() {
        adDAO = new AdDAOImpl();
        emailDAO = new EmailDAOImpl();
    }


    @Override
    public void deleteAll(Author author) {
        adDAO.deleteAll(author);
    }

    @Override
    public List<Ad> showAds(List<Integer> ids) {
        return adDAO.showAds(ids);
    }

    @Override
    public void save(Ad ad) {
        adDAO.insert(ad);
        emailDAO.sendEmails(ad);
    }

    @Override
    public Ad findById(int id) {
        return adDAO.findById(id);
    }

    @Override
    public void update(Ad ad) {
        adDAO.update(ad);
    }

    @Override
    public void deleteById(int id) {
        adDAO.deleteById(id);
    }

    @Override
    public List<Ad> findAll() {
        return adDAO.findAll();
    }
}
