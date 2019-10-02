package ru.bellintegrator.practice.organization.dao;

import java.util.List;
import java.util.Optional;

import ru.bellintegrator.practice.organization.model.Organization;

public interface OrganizationDao {

	// Get all organizations
	List<Organization> allOrganizations();

	// Get an organization by id
	Organization getOrganizationById(Integer id);

	// Save a new organization
	void save(Organization org);

	// Update an existing organization
	void update (Organization org);
	
	// Check if an organization exists
    boolean organizationExists(String name, String inn);

}
