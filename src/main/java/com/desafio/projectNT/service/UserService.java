package com.desafio.projectNT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.projectNT.dto.UserDto;
import com.desafio.projectNT.entity.User;
import com.desafio.projectNT.repository.UserRepository;

@Component
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User criarUsuario(User user) {
		return userRepository.save(user);
	}
	
	public List<User> listaUsuarios() {
		return	userRepository.findAll();
	}	
	
	public User AlteraPassword(long id, UserDto password) {
		User user1 = userRepository.findById(id).orElse(null);
		user1.setPassword(password.getPassword());
		return userRepository.save(user1);
	}
	
	public void deleteUsuario(Long id) {
		userRepository.deleteById(id);
	}	
}
