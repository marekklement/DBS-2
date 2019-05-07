package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Book;

public interface BookService {

	boolean createNewBook(Book book);

	List<Book> findAll();

	Book find(long id);
}
