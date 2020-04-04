package com.rav.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rav.springbootdemo.dto.CountryDto;
import com.rav.springbootdemo.repository.CountryDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService<CountryDto> {

	@Autowired
	private CountryDao<CountryDto> countryDao;

	@Override
	public Mono<CountryDto> get(String country) {
		return countryDao.get(country);
	}

	@Override
	public Flux<CountryDto> getAll(String sortBy) {
		return countryDao.getAll(sortBy);
	}

}
