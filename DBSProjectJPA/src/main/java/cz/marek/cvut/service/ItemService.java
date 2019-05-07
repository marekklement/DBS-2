package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Item;

public interface ItemService {

	boolean createNewItem(Item item);

	List<Item> findAll();

	Item find(long id);
}
