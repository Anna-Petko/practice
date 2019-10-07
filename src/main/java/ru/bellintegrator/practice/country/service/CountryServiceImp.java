package ru.bellintegrator.practice.country.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.view.CountryView;

@Service
@Transactional
public class CountryServiceImp implements CountryService {
	private final CountryDao countryDao;

	@Autowired
	public CountryServiceImp(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CountryView> getAllCountries() {
		return mapAllCountries(countryDao.all());
	}

	/**
	 * Mapping objects into entities
	 * 
	 * @param docs
	 * @return
	 */
	private List<CountryView> mapAllCountries(List<Country> countries) {
		List<CountryView> countryViews = new ArrayList<CountryView>();
		for(Country country: countries) {
			CountryView cw = mapCountry(country);
			countryViews.add(cw);
		}
		return countryViews;
	}

	/**
	 * Mapping an object into its entity
	 * 
	 * @param doc
	 * @return
	 */
	private CountryView mapCountry(Country country) {
		CountryView view = new CountryView();
		view.setCode(country.getCode());
		view.setName(country.getName());
		return view;
	}

}
