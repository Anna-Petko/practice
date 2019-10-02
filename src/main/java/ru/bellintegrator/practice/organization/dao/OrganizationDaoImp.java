package ru.bellintegrator.practice.organization.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

import ru.bellintegrator.practice.organization.model.Organization;

@Transactional
@Repository 
public class OrganizationDaoImp implements OrganizationDao {

	@PersistenceContext
	private EntityManager em;

	// Get all organizations
	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> allOrganizations() {
		String hqlString = "Select from Organization";
		return (List<Organization>)em.createQuery(hqlString).getResultList() ;
	}

	// Get an organization by id
	@Override
	public Organization getOrganizationById(Integer id) {
		return em.find(Organization.class, id);
	}

	// Save a new organization
	@Override
	public void save(Organization org) {
		em.persist(org);
	}

	// Update an existing organization
	@Override
	public void update(Organization org) {
		Organization org1 = getOrganizationById(org.getId());
		org1.setName(org.getName());
		org1.setAdress(org.getAdress());
		org1.setFullName(org.getFullName());
		org1.setInn(org.getInn());
		org1.setKpp(org.getKpp());
		em.flush();
	}

	@Override
	public boolean organizationExists(String name, String inn) {
		String hql = "FROM Organization as org WHERE org.name = ? and org.inn = ?";
		int count = em.createQuery(hql).setParameter(1, name).
				setParameter(2, inn).getResultList().size();
		return count > 0 ? true : false;
	}

}
