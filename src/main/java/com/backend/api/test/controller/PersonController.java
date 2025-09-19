package com.backend.api.test.controller;

import com.backend.api.test.model.Person;
import com.backend.api.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void save(@RequestBody Person person) {
		personService.savePerson(person);
	}
	
}
