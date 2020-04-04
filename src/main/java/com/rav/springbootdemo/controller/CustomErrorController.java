package com.rav.springbootdemo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
public class CustomErrorController implements ErrorController {	

	@GetMapping("${path.error}")
	public void onError() throws NotFoundException {
		throw new NotFoundException("Invalid");
	}

	@Override
	public String getErrorPath() {
		return "${path.error}";
	}
}
