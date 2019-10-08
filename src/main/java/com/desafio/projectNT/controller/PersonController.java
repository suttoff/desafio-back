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

import com.desafio.projectNT.dto.PersonProjetoDto;
import com.desafio.projectNT.dto.UserDto;
import com.desafio.projectNT.entity.Person;
import com.desafio.projectNT.entity.User;
import com.desafio.projectNT.service.PersonService;
import com.desafio.projectNT.service.UserService;

@Controller
@RequestMapping(path = "/colaborador")
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService PersonService) {
		this.personService = PersonService;
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(personService.criarColaborador(person), HttpStatus.CREATED);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<Person>> getAllPerson() {
		return new ResponseEntity<List<Person>>(personService.listaColaborador(), HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<Person> update(@RequestParam("id") Long id, @RequestBody PersonProjetoDto personDto) {
		return new ResponseEntity<Person>(personService.AlteraPerson(id, personDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Person> delete(@RequestParam("id") Long id) {
		personService.deleteColaborador(id);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}

}
