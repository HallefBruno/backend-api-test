package com.backend.api.test.service;

import com.backend.api.test.model.Person;
import com.backend.api.test.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public void savePerson(Person person) {
		personRepository.save(person);
	}
	
}
