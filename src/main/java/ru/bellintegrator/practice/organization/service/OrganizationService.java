package ru.bellintegrator.practice.organization.service;

import java.util.List;

import ru.bellintegrator.practice.organization.model.Organization;


public interface OrganizationService {
	// Get all organizations
	List<Organization> allOrganizations();

	// Get an organization by id
	Organization getOrganizationById(Integer id);

	// Save a new organization
	boolean save(Organization org);

	// Update an existing organization
	void update (Organization org);

}
