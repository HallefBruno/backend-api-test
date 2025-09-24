package com.backend.api.test.repository;

import com.backend.api.test.model.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	public Page<Person> buscarPaginado(int pageNumber, int pageSize) {
		String sql = "SELECT * FROM person LIMIT ? OFFSET ?";
		List<Person> pessoas = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), pageSize, pageNumber * pageSize);

		String countSql = "SELECT COUNT(*) FROM person";
		Integer total = jdbcTemplate.queryForObject(countSql, Integer.class);

		return new PageImpl<>(pessoas, PageRequest.of(pageNumber, pageSize), total);
	}
	
}
