package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.PieceDAO;
import cz.marek.cvut.dao.PieceDAOImpl;
import cz.marek.cvut.model.Piece;

public class PieceServiceImpl implements PieceService {

	private PieceDAO pieceDAO;

	public PieceServiceImpl() {
		this.pieceDAO = new PieceDAOImpl();
	}

	@Override
	public boolean createNewPiece(Piece piece) {
		pieceDAO.save(piece);
		return true;
	}

	@Override
	public List<Piece> findAll() {
		return pieceDAO.list();
	}

	@Override
	public Piece find(long id) {
		return pieceDAO.find(id);
	}
}
