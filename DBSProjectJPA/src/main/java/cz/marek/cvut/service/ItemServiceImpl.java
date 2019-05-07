package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.ItemDAO;
import cz.marek.cvut.dao.ItemDAOImpl;
import cz.marek.cvut.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDAO itemDAO;

	public ItemServiceImpl() {
		itemDAO = new ItemDAOImpl();
	}

	@Override
	public boolean createNewItem(Item item) {
		itemDAO.save(item);
		return true;
	}

	@Override
	public List<Item> findAll() {
		return itemDAO.list();
	}

	@Override
	public Item find(long id) {
		return itemDAO.find(id);
	}
}
