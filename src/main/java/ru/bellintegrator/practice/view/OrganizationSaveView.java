package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import ru.bellintegrator.practice.organization.model.Organization;

public class OrganizationSaveView {

	@NotEmpty
	@Size(max = 100)
	public String name;

	@NotEmpty
	@Size(max = 100)
	public String fullName;

	@NotEmpty
	@Size(min = 10, max = 100)
	public String inn;

	@NotEmpty
	@Size(min = 10, max = 100)
	public String kpp;

	@NotEmpty
	@Size(max = 100)
	public String address;

	@Size(min = 10, max = 100)
	public String phone;

	public Integer isActive;

	public OrganizationSaveView() {
	}

	public OrganizationSaveView(Organization organization) {
		name = organization.getName();
		fullName = organization.getFullName();
		inn = organization.getInn();
		kpp = organization.getKpp();
		address = organization.getAdress();
		phone = organization.getPhone();
		isActive = organization.getIsAtive();
	}

}