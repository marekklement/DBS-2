package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.dao.WorkerDAO;
import cz.marek.cvut.dao.WorkerDAOImpl;
import cz.marek.cvut.model.Worker;


public class WorkerServiceImpl implements WorkerService {

	private WorkerDAO workerDAO;

	public WorkerServiceImpl() {
		this.workerDAO = new WorkerDAOImpl();
	}

	@Override
	public boolean createNewWorker(Worker worker) {
		workerDAO.save(worker);
		return true;
	}

	@Override
	public List<Worker> findAll() {
		return workerDAO.list();
	}

	@Override
	public Worker find(long id) {
		return workerDAO.find(id);
	}
}
