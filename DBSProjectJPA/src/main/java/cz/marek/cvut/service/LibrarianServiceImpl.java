package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.LibrarianDAO;
import cz.marek.cvut.dao.LibrarianDAOImpl;
import cz.marek.cvut.model.Librarian;

public class LibrarianServiceImpl implements LibrarianService {

	private LibrarianDAO librarianDAO;

	public LibrarianServiceImpl() {
		this.librarianDAO = new LibrarianDAOImpl();
	}

	@Override
	public boolean createNewLibrarian(Librarian librarian) {
		librarianDAO.save(librarian);
		return true;
	}

	@Override
	public List<Librarian> findAll() {
		return librarianDAO.list();
	}

	@Override
	public Librarian find(long id) {
		return librarianDAO.find(id);
	}
}
