package ru.bellintegrator.practice.organization.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.view.OrganizationFilter;
import ru.bellintegrator.practice.view.OrganizationListView;
import ru.bellintegrator.practice.view.OrganizationSaveView;
import ru.bellintegrator.practice.view.OrganizationUpdateView;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.SuccessView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service 
public class OrganizationServiceImp implements OrganizationService {

	private OrganizationDao organizationDao;

	@Autowired
	public OrganizationServiceImp(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	@Override
	public OrganizationView findById(Integer id) {
		Objects.requireNonNull(id);
		Organization organization = organizationDao.findById(id);
		return new OrganizationView(id, organization);
	}

	@Override
	@Transactional
	public List<OrganizationListView> all(OrganizationFilter organizationFilter) {
		Objects.requireNonNull(organizationFilter);
		return organizationDao.all(organizationFilter)
				.stream()
				.map(org -> new OrganizationListView(org.getId(), org.getName(), org.getIsAtive()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public SuccessView save(OrganizationSaveView orgView) {
		Objects.requireNonNull(orgView);
		Organization organization = new Organization();
		organization.setName(orgView.name);
		organization.setFullName(orgView.fullName);
		organization.setInn(orgView.inn);
		organization.setKpp(orgView.kpp);
		organization.setAdress(orgView.address);
		organization.setPhone(orgView.phone);
		organization.setIsAtive(orgView.isActive);
		organizationDao.save(organization);
		return new SuccessView("Organization has been saved successfully");
	}

	@Override
	@Transactional
	public SuccessView update(OrganizationUpdateView orgView) {
		Objects.requireNonNull(orgView);
		Organization organization = new Organization();
		organization.setId(orgView.id);
		organization.setName(orgView.name);
		organization.setFullName(orgView.fullName);
		organization.setInn(orgView.inn);
		organization.setKpp(orgView.kpp);
		organization.setAdress(orgView.address);
		organization.setPhone(orgView.phone);
		organization.setIsAtive(orgView.isActive);
		organizationDao.update(organization);
		return new SuccessView("Organization has been updated successfully");
	}



}