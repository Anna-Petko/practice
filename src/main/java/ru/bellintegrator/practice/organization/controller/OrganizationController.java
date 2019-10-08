package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationFilter;
import ru.bellintegrator.practice.view.OrganizationListView;
import ru.bellintegrator.practice.view.OrganizationSaveView;
import ru.bellintegrator.practice.view.OrganizationUpdateView;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.SuccessView;;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

	private OrganizationService organizationService;

	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public OrganizationView get(@PathVariable Integer id) {
		return organizationService.findById(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<OrganizationListView> all(@Valid @RequestBody OrganizationFilter organizationFilter) {
		return organizationService.all(organizationFilter);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public SuccessView save(@Valid @RequestBody OrganizationSaveView orgView) {
		return organizationService.save(orgView);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public SuccessView update(@Valid @RequestBody OrganizationUpdateView orgView) {
		return organizationService.update(orgView);
	}

}