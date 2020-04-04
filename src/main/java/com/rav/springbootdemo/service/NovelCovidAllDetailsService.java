package com.rav.springbootdemo.service;

import reactor.core.publisher.Mono;

public interface NovelCovidAllDetailsService<T> {

	Mono<T> getAllDetails();

}
