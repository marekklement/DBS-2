package cz.marek.cvut.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

abstract class GenericDAO<T> implements DAO<T> {

	protected EntityManagerFactory emf;

	private Class<T> type;

	public GenericDAO(Class<T> type) {
		this.type = type;
	}

	GenericDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		emf = Persistence.createEntityManagerFactory("DBS_Project_JPA");
	}

	@Override
	public List<T> list() {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(type);
		Root<T> rootEntry = cq.from(type);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public T save(final T entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.flush();
		return entity;
	}

	@Override
	public void delete(final Object id) {
		EntityManager em = emf.createEntityManager();
		em.remove(em.getReference(type, id));
	}

	@Override
	public T find(final Object id) {
		EntityManager em = emf.createEntityManager();
		return em.find(type, id);
	}

	@Override
	public T update(final T entity) {
		EntityManager em = emf.createEntityManager();
		em.merge(entity);
		em.flush();
		return entity;
	}

}
