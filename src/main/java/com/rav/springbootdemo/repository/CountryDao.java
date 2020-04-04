package com.rav.springbootdemo.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryDao<T> {

	Mono<T> get(String country);

	Flux<T> getAll(String sortBy);
}
