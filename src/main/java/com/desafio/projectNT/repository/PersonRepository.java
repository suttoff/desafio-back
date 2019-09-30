package com.desafio.projectNT.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafio.projectNT.entity.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
