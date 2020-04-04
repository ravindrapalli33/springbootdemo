package com.rav.springbootdemo.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryService<T> {

	Mono<T> get(String country);

	Flux<T> getAll(String sortBy);

}
