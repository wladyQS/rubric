package org.rubric.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.rubric.dao.CrudDAO;
import org.rubric.dao.impl.AuthorDAOImpl;
import org.rubric.domain.Author;
import org.rubric.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements CrudService<Author> {
    CrudDAO<Author> authorDAO;

    @Override
    public void save(Author author) {
        authorDAO.insert(author);
    }

    @Override
    public Author findById(int id) {
        return authorDAO.findById(id);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void deleteById(int id) {
        authorDAO.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}
