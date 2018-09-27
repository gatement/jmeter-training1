package com.midea.sda.training.jmeter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.midea.sda.training.jmeter.dto.ApiError;
import com.midea.sda.training.jmeter.dto.Student;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class StudentController {
	
	private static Integer id = 1;
	private static List<Student> students = new ArrayList<Student>();
	static {
		students.add(new Student(id, "Johnson", 18));
	}

	// curl -i -XGET http://localhost:8080/student"
    @GetMapping("/student")
    public Mono<Object> list() {
		return Mono.just(students);
    }

    // curl -i -XPOST -H "token: jLXPanGes0pocTbRkanwlk9tryFzYEq9" -d "name=john&age=10" "http://localhost:8080/student"
    @PostMapping("/student")
    public Mono<Object> create(Student student, @RequestHeader(defaultValue = "") String token) {
    	if (!token.equals(LoginController.TOKEN)) {
    		return Mono.just(ApiError.INVALID_TOKEN);
    	}

		student.setId(++id);
		students.add(student);
		return Mono.just("ok");
    }
}