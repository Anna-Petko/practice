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
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "inn")
	private String inn;

	@Column(name = "is_active")
	private Integer isAtive;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "kpp")
	private String kpp;

	@Column(name = "adress")
	private String adress;

	@Column(name = "phone")
	private String phone;


	public Organization() {

	}

	public Organization(String name, String inn, Integer isActive ,String fullName,String kpp, 
			String adress,String phone) {
		this.name = name;
		this.inn = inn;
		this.inn = inn;
		this.isAtive = isActive;
		this.fullName = fullName;
		this.kpp = kpp;
		this.adress = adress;
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
		return adress;
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

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

