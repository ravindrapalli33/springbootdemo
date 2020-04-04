package com.rav.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rav.springbootdemo.dto.NovelCovidAllDetailsDto;
import com.rav.springbootdemo.service.NovelCovidAllDetailsService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${path.novelcovid19.urls.all_details}")
public class NovelCovidAllDetailsController {

	@Autowired
	private NovelCovidAllDetailsService<NovelCovidAllDetailsDto> novelCovidAllDetailsService;

	@GetMapping("")
	public Mono<NovelCovidAllDetailsDto> getAllDetails() {
		try {
			return novelCovidAllDetailsService.getAllDetails();
		} catch (Exception e) {
			throw e;
		}
	}
}
