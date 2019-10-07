package ru.bellintegrator.practice.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * country
 */

@Entity
@Table(name = "Country")
public class Country {

	/**
	 * id
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	/**
	 * country name
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;


	/**
	 * country code
	 */
	@Column(name = "code", length = 50, nullable = false)
	private String code;


	public long getId() {
		return id;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
