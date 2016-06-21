package ru.FL.SpringLibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.FL.SpringLibrary.dao.interfaces.bookDAO;
import ru.FL.SpringLibrary.entities.Author;
import ru.FL.SpringLibrary.entities.Book;

import java.util.List;

/**
 * Created by F4KEFLY on 10.06.2016.
 * Description:
 * TODO:
 */
@Component("libraryFacade")
@Scope("singleton")
public class LibraryFacade
{
    private static final String FIELD_CONTENT = "content";

    @Autowired
    private bookDAO bookDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Book> books;

    public List<Book> getBooks()
    {
        if (books == null) {
            books = bookDAO.getBooks();
        }
        return books;
    }

    public void searchBooksByLetter()
    {
        books = bookDAO.getBooks(searchCriteria.getLetter());
    }

    public void searchBooksByGenre()
    {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText()
    {
        switch (searchCriteria.getSearchType()) {
            case TITLE:
                books = bookDAO.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDAO.getBooks(new Author(searchCriteria.getText()));
                break;
        }
    }

    public byte[] getContent(Long id){
        return (byte[])bookDAO.getFieldValue(id, FIELD_CONTENT);
    }
}