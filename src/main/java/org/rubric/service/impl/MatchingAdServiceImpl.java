package org.rubric.service.impl;

import org.rubric.dao.CrudDAO;
import org.rubric.dao.impl.MatchingAdDAOImpl;
import org.rubric.domain.MatchingAd;
import org.rubric.service.CrudService;

import java.util.List;

public class MatchingAdServiceImpl implements CrudService<MatchingAd> {
    private final CrudDAO<MatchingAd> matchingAdDAO;

    public MatchingAdServiceImpl() {
        this.matchingAdDAO = new MatchingAdDAOImpl();
    }


    @Override
    public void save(MatchingAd matchingAd) {
        matchingAdDAO.insert(matchingAd);
    }

    @Override
    public MatchingAd findById(int id) {
        return matchingAdDAO.findById(id);
    }

    @Override
    public void update(MatchingAd matchingAd) {
        matchingAdDAO.update(matchingAd);
    }

    @Override
    public void deleteById(int id) {
        matchingAdDAO.deleteById(id);
    }

    @Override
    public List<MatchingAd> findAll() {
        return matchingAdDAO.findAll();
    }
}
