package org.rubric.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.rubric.dao.CrudDAO;
import org.rubric.dao.impl.MatchingAdDAOImpl;
import org.rubric.domain.MatchingAd;
import org.rubric.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MatchingAdServiceImpl implements CrudService<MatchingAd> {
    CrudDAO<MatchingAd> matchingAdDAO;

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
