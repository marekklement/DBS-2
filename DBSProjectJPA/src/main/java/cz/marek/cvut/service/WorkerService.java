package cz.marek.cvut.service;

import java.util.List;

import cz.marek.cvut.model.Worker;

public interface WorkerService {

	boolean createNewWorker(Worker worker);

	List<Worker> findAll();

	Worker find(long id);
}
