package cz.marek.cvut.service;

import javax.inject.Inject;

import org.junit.Test;

import cz.marek.cvut.model.Book;
import junit.framework.TestCase;

public class BookServiceImplTest extends TestCase {

	@Inject
	private BookService bookService;

	@Test
	public void testCreateBook() {
		//bookService = new BookServiceImpl();
		Book book = new Book();
		book.setTitle("bagr");
		book.setSerialNumber("123NN");
		book.setYear(1999);
		bookService = new BookServiceImpl();
		bookService.createNewBook(book);
	}
}
