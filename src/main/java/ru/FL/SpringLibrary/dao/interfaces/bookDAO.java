package ru.FL.SpringLibrary.dao.interfaces;


import ru.FL.SpringLibrary.entities.Author;
import ru.FL.SpringLibrary.entities.Book;
import ru.FL.SpringLibrary.entities.Genre;

import java.util.List;


public interface bookDAO
{

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);
    Object getFieldValue(Long id, String fieldName);

}
