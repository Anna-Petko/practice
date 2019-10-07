package ru.bellintegrator.practice.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;

@Service
public class OrganizationServiceImp implements OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<Organization> allOrganizations() {
		return organizationDao.allOrganizations();
	}

	@Override
	public Organization getOrganizationById(Integer id) {
		Organization org1 = organizationDao.getOrganizationById(id);
		return org1;
	}

	@Override
	public boolean save(Organization org) {
		if (organizationDao.organizationExists(org.getName(), org.getInn())) {
			return false;
		} else {
			organizationDao.save(org);
			return true;
		}
	}

	@Override
	public void update(Organization org) {
		organizationDao.update(org);		
	}

}
