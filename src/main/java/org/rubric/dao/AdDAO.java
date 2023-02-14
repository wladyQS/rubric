package org.rubric.dao;

import org.rubric.domain.Ad;
import org.rubric.domain.Address;
import org.rubric.domain.Author;
import org.rubric.domain.Rubric;

import java.util.List;

public interface AdDAO extends CrudDAO<Ad> {
    void deleteAll(Author author);
    List<Ad> showAds(List<Integer> ids);
}
