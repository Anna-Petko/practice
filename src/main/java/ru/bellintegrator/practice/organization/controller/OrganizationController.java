package ru.bellintegrator.practice.organization.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationServiceImp;

@Controller
@RequestMapping("api/organization")
public class OrganizationController {
	@Autowired
	private OrganizationServiceImp organizationService;

	@GetMapping("/{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") Integer id) {
		Organization org = organizationService.getOrganizationById(id);
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Organization>> allOrganizations() {
		List<Organization> list = organizationService.allOrganizations();
		return new ResponseEntity<List<Organization>>(list, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody Organization org, UriComponentsBuilder builder) {
		boolean flag = organizationService.save(org);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/organization/{id}").buildAndExpand(org.getId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Organization> update(@RequestBody Organization org) {
		organizationService.update(org);
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
}
