package ru.bellintegrator.practice.country.service;

import java.util.List;

import ru.bellintegrator.practice.view.CountryView;

public interface CountryService {

	/**
	 * getting the list of all countries
	 * 
	 * @return
	 */
	List<CountryView> getAllCountries();

}
