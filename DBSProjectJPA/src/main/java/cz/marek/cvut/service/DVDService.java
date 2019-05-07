package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.DVD;

public interface DVDService {

	boolean createNewDVD(DVD dvd);

	List<DVD> findAll();

	DVD find(long id);
}
