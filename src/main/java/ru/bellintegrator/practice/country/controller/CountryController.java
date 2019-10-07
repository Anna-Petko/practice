package ru.bellintegrator.practice.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.bellintegrator.practice.country.service.CountryService;
import ru.bellintegrator.practice.view.CountryView;



@RestController
public class CountryController {
	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	/**
	 * responsible for mapping the list of all countries
	 */
	@RequestMapping(value = "api/countries", method = RequestMethod.GET)
	public List<CountryView> all(){
		return countryService.getAllCountries();
	}

}
