package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ru.bellintegrator.practice.organization.repository.OrganizationRepository;
import ru.bellintegrator.practice.organization.exception.ResourceNotFoundException;
import ru.bellintegrator.practice.organization.model.*;;


@RestController
@RequestMapping("/api/v1")
public class OrganizationController {
	@Autowired
	private OrganizationRepository organizationRepository;

	@GetMapping("/organizations") 
	public List<Organization> getAllEmployees() {
		return organizationRepository.findAll();
	}

	@GetMapping("/organizations/{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable(value = "id") Integer id)
	throws ResourceNotFoundException
	{
		Organization organization = organizationRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Organization not found for this id :: " + id));
				return ResponseEntity.ok().body(organization);
	}


}
