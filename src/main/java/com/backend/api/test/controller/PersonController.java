package com.backend.api.test.controller;

import com.backend.api.test.model.Person;
import com.backend.api.test.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/{pageNumber}/{pageSize}")
	public ResponseEntity<?> list(@PathVariable(name = "pageNumber", required = true) int pageNumber, 
			@PathVariable(name = "pageSize", required = true) int pageSize) {
		var data = personService.getPagePerson(pageNumber, pageSize);
		if(!data.getContent().isEmpty()) return ResponseEntity.ok(data);
		return ResponseEntity.noContent().build();
	}
	
}
