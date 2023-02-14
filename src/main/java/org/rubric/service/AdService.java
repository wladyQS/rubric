package org.rubric.service;

import org.rubric.domain.Ad;
import org.rubric.domain.Author;
import org.rubric.domain.Rubric;

import java.util.List;

public interface AdService extends CrudService<Ad> {
    void deleteAll(Author author);
    List<Ad> showAds(List<Integer> ids);
}
