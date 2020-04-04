package com.rav.springbootdemo.repository;

import reactor.core.publisher.Mono;

public interface NovelCovidAllDetailsDao<T> {

	Mono<T> getAllDetails();
}
