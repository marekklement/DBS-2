package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Piece;

public interface PieceService {

	boolean createNewPiece(Piece piece);

	List<Piece> findAll();

	Piece find(long id);
}
