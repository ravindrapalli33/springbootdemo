package com.rav.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rav.springbootdemo.dto.NovelCovidAllDetailsDto;
import com.rav.springbootdemo.repository.NovelCovidAllDetailsDao;

import reactor.core.publisher.Mono;

@Service
public class NovelCovidAllDetailsServiceImpl implements NovelCovidAllDetailsService<NovelCovidAllDetailsDto> {

	@Autowired
	private NovelCovidAllDetailsDao<NovelCovidAllDetailsDto> novelCovidAllDetailsDao;

	@Override
	public Mono<NovelCovidAllDetailsDto> getAllDetails() {
		return novelCovidAllDetailsDao.getAllDetails();
	}

}
