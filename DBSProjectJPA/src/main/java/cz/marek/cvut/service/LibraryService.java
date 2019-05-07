package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Library;

public interface LibraryService {

	boolean createNewLibrary(Library library);

	List<Library> findAll();

	Library find(long id);
}
