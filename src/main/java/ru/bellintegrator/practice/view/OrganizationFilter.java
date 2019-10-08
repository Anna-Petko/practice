package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationFilter {

	@Size(max = 100)
	@NotEmpty
	public String name;

	@Size(min = 10, max = 100)
	public String inn;

	public Integer isActive;

	public OrganizationFilter() {
	}

	public OrganizationFilter(String name, String inn, Integer isActive) {
		this.name = name;
		this.inn = inn;
		this.isActive = isActive;
	}
}