package ru.bellintegrator.practice.organization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "inn", length = 50, nullable = false)
	private String inn;

	@Column(name = "is_active",  nullable = false)
	private Integer isAtive;

	@Column(name = "full_name",length = 50, nullable = false)
	private String fullName;

	@Column(name = "kpp", length = 50, nullable = false)
	private String kpp;

	@Column(name = "address", length = 50, nullable = false)
	private String address;

	@Column(name = "phone", length = 50)
	private String phone;

	/*
	 * Empty constructor for JPA
	 */
	public Organization() {

	}

	public Organization(String name, String inn, Integer isActive ,String fullName,String kpp, 
			String address,String phone) {
		this.name = name;
		this.inn = inn;
		this.inn = inn;
		this.isAtive = isActive;
		this.fullName = fullName;
		this.kpp = kpp;
		this.address = address;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInn() {
		return inn;
	}

	public Integer getIsAtive() {
		return isAtive;
	}

	public String getFullName() {
		return fullName;
	}

	public String getKpp() {
		return kpp;
	}

	public String getAdress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public void setIsAtive(Integer isAtive) {
		this.isAtive = isAtive;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(Integer id) {
		this.id = id;

	}

}

