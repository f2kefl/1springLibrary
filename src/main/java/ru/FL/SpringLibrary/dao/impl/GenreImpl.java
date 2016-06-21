package ru.FL.SpringLibrary.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.FL.SpringLibrary.entities.Genre;
import ru.FL.SpringLibrary.dao.interfaces.genreDAO;

import java.util.List;

/**
 * Created by F4KEFLY on 09.06.2016.
 * Description:
 * TODO:
 */
@Component
public class GenreImpl implements genreDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Genre> getGenres()
    {
        return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
    }
}
