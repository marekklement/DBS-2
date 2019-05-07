package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.DVDDAO;
import cz.marek.cvut.dao.DVDDAOImpl;
import cz.marek.cvut.model.DVD;

public class DVDServiceImpl implements DVDService {

	private DVDDAO dvddao;

	public DVDServiceImpl() {
		this.dvddao = new DVDDAOImpl();
	}

	@Override
	public boolean createNewDVD(DVD dvd) {
		dvddao.save(dvd);
		return true;
	}

	@Override
	public List<DVD> findAll() {
		return dvddao.list();
	}

	@Override
	public DVD find(long id) {
		return dvddao.find(id);
	}
}
