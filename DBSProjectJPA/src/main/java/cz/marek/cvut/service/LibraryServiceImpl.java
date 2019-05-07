package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.LibraryDAO;
import cz.marek.cvut.dao.LibraryDAOImpl;
import cz.marek.cvut.model.Library;

public class LibraryServiceImpl implements LibraryService {

	private LibraryDAO libraryDAO;

	public LibraryServiceImpl() {
		this.libraryDAO = new LibraryDAOImpl();
	}

	@Override
	public boolean createNewLibrary(Library library) {
		libraryDAO.save(library);
		return true;
	}

	@Override
	public List<Library> findAll() {
		return libraryDAO.list();
	}

	@Override
	public Library find(long id) {
		return libraryDAO.find(id);
	}
}
