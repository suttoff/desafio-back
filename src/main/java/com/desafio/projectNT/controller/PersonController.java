package com.desafio.projectNT.controller;

import com.desafio.projectNT.dto.PersonProjetoDto;
import com.desafio.projectNT.entity.Person;
import com.desafio.projectNT.exception.NotFoundException;
import com.desafio.projectNT.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable("id") Long id, @RequestBody PersonProjetoDto personDto) throws NotFoundException {
        return service.update(id, personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws NotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
