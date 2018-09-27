package com.midea.sda.training.jmeter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midea.sda.training.jmeter.dto.ApiError;
import com.midea.sda.training.jmeter.dto.LoginReq;
import com.midea.sda.training.jmeter.dto.LoginRes;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class LoginController {
	
	public static String TOKEN = "jLXPanGes0pocTbRkanwlk9tryFzYEq9";

    // curl -i -XPOST -d "username=username1&password=password1" "http://localhost:8080/login"
    @PostMapping("/login")
    public Mono<Object> getStudents(LoginReq user) {
    	if (user.getUsername().equals("username1") && user.getPassword().equals("password1")) {
    		return Mono.just(new LoginRes(TOKEN));
    	} else {
    		return Mono.just(ApiError.LOGIN_FAIL);
    	}
    }
}