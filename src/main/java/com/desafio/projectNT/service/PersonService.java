package com.desafio.projectNT.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.projectNT.dto.PersonProjetoDto;
import com.desafio.projectNT.entity.Person;
import com.desafio.projectNT.repository.PersonRepository;

@Component
public class PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person criarColaborador(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> listaColaborador() {
		return	personRepository.findAll();
	}	
	
	public Person AlteraPerson(long id, PersonProjetoDto personDto) {
		Person person = personRepository.findById(id).orElse(null);
		person.setCargo(personDto.getCargo());
		person.setProjeto(personDto.getProjeto());
		return personRepository.save(person);
	}
	
	
	public void deleteColaborador(Long id) {
		personRepository.deleteById(id);
	}	

}
