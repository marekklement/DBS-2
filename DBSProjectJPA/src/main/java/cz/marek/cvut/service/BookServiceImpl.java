package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.BookDAO;
import cz.marek.cvut.dao.BookDAOImpl;
import cz.marek.cvut.model.Book;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;

	public BookServiceImpl() {
		bookDAO = new BookDAOImpl();
	}

	@Override
	public boolean createNewBook(Book book) {
		bookDAO.save(book);
		return true;
	}

	@Override
	public List<Book> findAll() {
		return bookDAO.list();
	}

	@Override
	public Book find(long id) {
		return bookDAO.find(id);
	}
}
