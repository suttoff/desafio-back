package com.desafio.projectNT.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.projectNT.dto.UserDto;
import com.desafio.projectNT.entity.User;
import com.desafio.projectNT.service.UserService;

@Controller 
@RequestMapping(path="/usuarios") 
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService UserService) {
		this.userService = UserService;
	}

	@PostMapping(path="/add") 
	public ResponseEntity<User> addNewUser(@RequestBody User user) {		
		return new ResponseEntity<User>(userService.criarUsuario(user), HttpStatus.CREATED);
	}

	@GetMapping(path="/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.listaUsuarios(), HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<User> update(@RequestParam("id") Long id, @RequestBody UserDto password) {
		return new ResponseEntity<User>(userService.AlteraPassword(id,password), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<User> delete(@RequestParam("id") Long id) {
		userService.deleteUsuario(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	
	
	
}