package ru.bellintegrator.practice.view;

import ru.bellintegrator.practice.organization.model.Organization;

public class OrganizationView {

	public Integer id;

	public String name;

	public String fullName;

	public String inn;

	public String kpp;

	public String address;

	public String phone;

	public Integer isActive;

	public OrganizationView() {
	}

	public OrganizationView(Integer id, Organization organization) {
		this.id = id;
		name = organization.getName();
		fullName = organization.getFullName();
		inn = organization.getInn();
		kpp = organization.getKpp();
		address = organization.getAdress();
		phone = organization.getPhone();
		isActive = organization.getIsAtive();
	}

}