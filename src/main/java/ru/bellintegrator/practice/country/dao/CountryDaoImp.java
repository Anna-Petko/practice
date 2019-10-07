package ru.bellintegrator.practice.country.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.practice.country.model.Country;

/**
 * {@inheritDoc}
 */

@Repository
public class CountryDaoImp implements CountryDao {
	private final EntityManager em;

	@Autowired
	public CountryDaoImp(EntityManager em) {
		this.em = em;	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Country> all() {
		TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
		return query.getResultList();
	}

}
