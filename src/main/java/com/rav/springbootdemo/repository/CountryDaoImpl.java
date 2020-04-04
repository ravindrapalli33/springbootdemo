package com.rav.springbootdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.rav.springbootdemo.dto.CountryDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CountryDaoImpl implements CountryDao<CountryDto> {

	@Value("${novelcovid19.urls.country_details}") private String novelCovidCountryDetails;

	@Value("${novelcovid19.urls.all_countries}") private String novelCovidAllDetails;

	@Autowired
	private WebClient novelCovidWebClient;

	@Override
	public Mono<CountryDto> get(String country) {
		return novelCovidWebClient.get()
		        .uri(uriBuilder -> uriBuilder
		        		.path("/")
						.path(novelCovidCountryDetails)
						.pathSegment(country)
		                .build()
		        )
		        .retrieve()
		        .bodyToMono(CountryDto.class);
	}

	@Override
	public Flux<CountryDto> getAll(String sortBy) {
		return novelCovidWebClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/")
						.path(novelCovidAllDetails)
		                .queryParam("sort", sortBy)
		                .build()
		        )
		        .retrieve()
		        .onStatus(HttpStatus::is4xxClientError, response ->
	                Mono.error(new Exception("401"))
	            )
	            .onStatus(HttpStatus::is5xxServerError, response ->
	                Mono.error(new Exception("501"))
	            )
		        .bodyToFlux(CountryDto.class);
	}

}
