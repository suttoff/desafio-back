package com.desafio.projectNT.service;

import com.desafio.projectNT.dto.PersonProjetoDto;
import com.desafio.projectNT.entity.Person;
import com.desafio.projectNT.exception.NotFoundException;
import com.desafio.projectNT.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person update(long id, PersonProjetoDto personDto) throws NotFoundException {
        Person person = repository.findById(id)
                .orElseThrow(NotFoundException::new);

        person.setCargo(personDto.getCargo());
        person.setProjeto(personDto.getProjeto());
        return repository.save(person);
    }

    public void delete(Long id) throws NotFoundException {
		repository.findById(id).orElseThrow(NotFoundException::new);
		repository.deleteById(id);
    }
}
