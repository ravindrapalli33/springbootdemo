package com.rav.springbootdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.rav.springbootdemo.dto.NovelCovidAllDetailsDto;

import reactor.core.publisher.Mono;

@Component
public class NovelCovidAllDetailsImpl implements NovelCovidAllDetailsDao<NovelCovidAllDetailsDto> {

	@Value("${novelcovid19.urls.all_details}") private String novelCovidAllDetails;

	@Autowired
	private WebClient novelCovidWebClient;

	@Override
	public Mono<NovelCovidAllDetailsDto> getAllDetails() {
		return novelCovidWebClient.get()
		        .uri(uriBuilder -> uriBuilder
		        		.path("/")
						.path(novelCovidAllDetails)
		                .build()
		        )
		        .retrieve()
		        .bodyToMono(NovelCovidAllDetailsDto.class);
	}

}
