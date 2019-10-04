package com.desafio.projectNT.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafio.projectNT.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();

	User findByUsername(String username);

	
}