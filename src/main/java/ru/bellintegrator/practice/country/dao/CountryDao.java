package ru.bellintegrator.practice.country.dao;

import java.util.List;


import ru.bellintegrator.practice.country.model.Country;

/**
 * DAO for country
 */
public interface CountryDao {

	/**
	 * getting all countries
	 * 
	 * @return
	 */
	public List<Country> all();

}