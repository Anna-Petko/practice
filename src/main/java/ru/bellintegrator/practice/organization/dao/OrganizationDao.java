package ru.bellintegrator.practice.organization.dao;

import java.util.List;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.view.OrganizationFilter;

public interface OrganizationDao {

	/*
	 * Getting all organizations 
	 */
	List<Organization> all(OrganizationFilter orgFilter);

	/*
	 * Getting an organization by id
	 */
	Organization findById(Integer id);

	/*
	 * Adding a new organization
	 */
	void save(Organization org);

	/*
	 * Changing an existing organization
	 */
	void update(Organization org);

}


