package ru.bellintegrator.practice.document.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Document
 */

@Entity
@Table(name = "Document")
public class Document {

	/**
	 * id document
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;

	/**
	 * code document
	 */
	@Column(name = "code", length = 50, nullable = false)
	private String code;

	/**
	 * name document
	 */
	@Column(name = "name", length = 150, nullable = false)
	private String name;

	/**
	 * constructor
	 */

	public Document() {

	}

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
