package cz.marek.cvut.service;

import org.junit.Test;

import cz.marek.cvut.model.Book;
import junit.framework.TestCase;

public class BookServiceImplTest extends TestCase {

	private BookService bookService;

	@Test
	public void testCreateBook() {
		//bookService = new BookServiceImpl();
		Book book = new Book();
		book.setTitle("bagr");
		book.setSerialNumber("123NN");
		book.setYear(1999);
		bookService = new BookServiceImpl();
		Exception ex = null;
		try {
			bookService.createNewBook(book);
		} catch (Exception e){
			ex = e;
		}
		assertNotNull(ex);
		Book book1Found = bookService.find(1L);
		assertNotNull(book1Found);
		assertEquals("Not same books", book.getTitle(), book1Found.getTitle());
	}
}
