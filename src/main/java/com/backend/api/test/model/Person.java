package com.backend.api.test.model;


public class Person {
	
	private Long id;
	private Integer age;
	private String name;

	public Person() {
	}
	
	public Person(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	public Person(Long id, Integer age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
