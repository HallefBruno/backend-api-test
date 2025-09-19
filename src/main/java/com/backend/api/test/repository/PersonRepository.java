package com.backend.api.test.repository;

import com.backend.api.test.model.Person;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (age, name) VALUES (?, ?)",person.getAge(), person.getName());
    }
	
	public List<Person> findAll() {
        return jdbcTemplate.query(
            "SELECT id, age, name FROM person",
            (rs, rowNum) -> new Person(rs.getLong("id"), rs.getInt("age"), rs.getString("name")));
    }
	
}
