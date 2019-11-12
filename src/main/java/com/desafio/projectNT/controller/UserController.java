package com.desafio.projectNT.controller;

import java.util.List;

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

import com.desafio.projectNT.dto.UserDto;
import com.desafio.projectNT.entity.User;
import com.desafio.projectNT.exception.NotFoundException;
import com.desafio.projectNT.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/buscaId")
    public User getUser(Long id) {
        return service.getId(id);
    }

    @GetMapping("/findUsername")
    public User getUsername(String username) throws Exception {
        return service.getUsername(username);
    }

    @GetMapping("/checkLicense")
    public User getLicenca(String username) throws Exception {
        return service.checkLicense(username);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody UserDto password) throws NotFoundException {
        return service.updatePassword(id, password);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws NotFoundException {
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}