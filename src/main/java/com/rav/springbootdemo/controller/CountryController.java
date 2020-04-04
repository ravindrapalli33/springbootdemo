package com.rav.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rav.springbootdemo.dto.CountryDto;
import com.rav.springbootdemo.service.CountryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${path.novelcovid19.urls.countries_base}")
public class CountryController {

	@Autowired
	private CountryService<CountryDto> countryService;

	@GetMapping("${path.novelcovid19.urls.get_country_by_name}")
	public Mono<CountryDto> getCountryDetails(@PathVariable String country) {
		try {
			return countryService.get(country);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("${path.novelcovid19.urls.all_countries}")
	public Flux<CountryDto> getAllCountryDetails(@RequestParam(required = false, defaultValue = "country") String sortBy) {
		try {
			return countryService.getAll(sortBy);
		} catch (Exception e) {
			throw e;
		}
	}
}
