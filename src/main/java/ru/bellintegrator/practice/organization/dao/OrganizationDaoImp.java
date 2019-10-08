package ru.bellintegrator.practice.organization.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.practice.organization.exception.NoSuchEntityDaoException;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.view.OrganizationFilter;

@Repository
public class OrganizationDaoImp implements OrganizationDao {

	private final EntityManager em;

	@Autowired
	public OrganizationDaoImp(EntityManager em) {
		this.em = em;
	}

	/*
	 * The list of all organizations
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Organization> all(OrganizationFilter orgFilter) {
		Objects.requireNonNull(orgFilter);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
		Root<Organization> orgRoot = criteriaQuery.from(Organization.class);
		List<Predicate> predicateList = new ArrayList<>();

		if (Strings.isNotEmpty(orgFilter.name)) {
			predicateList.add((Predicate) criteriaBuilder.equal(orgRoot.get("name"), orgFilter.name));
		}

		if (Strings.isNotEmpty(orgFilter.inn)) {
			predicateList.add((Predicate) criteriaBuilder.equal(orgRoot.get("inn"), orgFilter.inn));
		}

		predicateList.add((Predicate) criteriaBuilder.equal(orgRoot.get("isActive"), orgFilter.isActive));

		criteriaQuery.select(orgRoot).where((javax.persistence.criteria.Predicate[]) predicateList.toArray(new Predicate[]{}));
		return em.createQuery(criteriaQuery).getResultList();
	}

	/*
	 * Get an organization by id
	 */
	@Override
	public Organization findById(Integer id) {
		Objects.requireNonNull(id);
		Organization organization = em.find(Organization.class, id);
		if (organization != null) {
			return organization;
		} else {
			throw new NoSuchEntityDaoException("No such organization with id=" + id);
		}
	}

	/*
	 * Save a new organization
	 */
	@Override
	public void save(Organization org) {
		Objects.requireNonNull(org);
		em.persist(org);
	}

	/*
	 * Changing an existing organization
	 */
	@Override
	public void update(Organization org) {
		Objects.requireNonNull(org);
		Organization orgToUpdate = em.find(Organization.class, org.getId());
		if (orgToUpdate != null) {
			orgToUpdate.setName(org.getName());
			orgToUpdate.setFullName(org.getFullName());
			orgToUpdate.setInn(org.getInn());
			orgToUpdate.setKpp(org.getKpp());
			orgToUpdate.setAdress(org.getAdress());
			orgToUpdate.setPhone(org.getPhone());
			orgToUpdate.setIsAtive(org.getIsAtive());
		} else {
			throw new NoSuchEntityDaoException("No such organization to update");
		}
	}

}