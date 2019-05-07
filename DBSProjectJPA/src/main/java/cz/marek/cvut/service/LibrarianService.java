package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Librarian;

public interface LibrarianService {

	boolean createNewLibrarian(Librarian librarian);

	List<Librarian> findAll();

	Librarian find(long id);
}
