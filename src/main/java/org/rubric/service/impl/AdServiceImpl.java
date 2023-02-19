package org.rubric.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.rubric.dao.AdDAO;
import org.rubric.dao.EmailDAO;
import org.rubric.dao.impl.AdDAOImpl;
import org.rubric.dao.impl.EmailDAOImpl;
import org.rubric.domain.Ad;
import org.rubric.domain.Author;
import org.rubric.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdServiceImpl implements AdService {

    AdDAO adDAO;
    EmailDAO emailDAO;

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
