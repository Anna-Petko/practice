package ru.bellintegrator.practice.document.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.practice.document.model.Document;

/**
 * implemented DAO for a document
 */
@Repository
public class DocumentDaoImp implements DocumentDao {
	private final EntityManager em;

	/**
	 * Dependency injection entityManager via constructor
	 * 
	 * @param em
	 */
	@Autowired
	public DocumentDaoImp(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Document> all() {
		TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Document loadById(Integer id) {
		return em.find(Document.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Document> loadByName(String name) {
		CriteriaQuery<Document> criteria = buildCriteriaName(name);
		TypedQuery<Document> query = em.createQuery(criteria);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Document> loadByCode(String code) {
		CriteriaQuery<Document> criteria = buildCriteriaCode(code);
		TypedQuery<Document> query = em.createQuery(criteria);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Document doc) {
		em.persist(doc);
	}

	/**
	 * criteria for searching document by name
	 * 
	 * @param name
	 * @return
	 */
	private CriteriaQuery<Document> buildCriteriaName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Document> criteria = builder.createQuery(Document.class);
		Root<Document> org = criteria.from(Document.class);

		List<Predicate> predicates = new ArrayList<>();
		if (name != null) {
			predicates.add(builder.equal(org.get("name"), name));
		}
		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}
	/**
	 * criteria for searching document by code
	 * 
	 * @param name
	 * @return
	 */
	private CriteriaQuery<Document> buildCriteriaCode(String code) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Document> criteria = builder.createQuery(Document.class);
		Root<Document> org = criteria.from(Document.class);

		List<Predicate> predicates = new ArrayList<>();
		if (code != null) {
			predicates.add(builder.equal(org.get("code"), code));
		}
		criteria.where(predicates.toArray(new Predicate[] {}));
		return criteria;
	}
}
