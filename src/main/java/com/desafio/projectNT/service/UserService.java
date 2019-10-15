package com.desafio.projectNT.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.desafio.projectNT.dto.UserDto;
import com.desafio.projectNT.entity.User;
import com.desafio.projectNT.exception.NotFoundException;
import com.desafio.projectNT.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repository;

	public UserService(UserRepository userRepository) {
		this.repository = userRepository;
	}

	public User create(User user) {
		return repository.save(user);
	}

	public List<User> getAll() {
		return repository.findAll();
	}

	public User getId(long id) {
		return repository.findById(id).orElse(null);
	}

	public User getUsername(String username) throws Exception {
		User user = repository.findByUsername(username);
		if (user == null) {
			throw new Exception();
		} else {
			return user;
		}
	}

	public User checkLicense(String username) throws Exception {
		User user = repository.findByUsername(username);
		if (user.isLicenca() == true) {
			return user;
		}
		throw new Exception();
	}

	public User updatePassword(long id, UserDto password) {
		User user1 = repository.findById(id).orElse(null);
		user1.setPassword(password.getPassword());
		return repository.save(user1);
	}

	public void deleteUser(Long id) throws NotFoundException {
		repository.findById(id).orElseThrow(NotFoundException::new);
		repository.deleteById(id);
	}

}
