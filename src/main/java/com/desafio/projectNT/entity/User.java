package com.desafio.projectNT.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "Usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username é Obrigatório.")
	private String username;

	@NotBlank(message = "Password é Obrigatório.")
	private String password;

	@NotBlank(message = "CPF é Obrigatório.")
	private String cpf;

	@Email
	private String email;

	@NotBlank(message = "Tipo de Usuário é Obrigatório.")
	private String tipoUser;
	
	private boolean licenca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	public boolean isLicenca() {
		return licenca;
	}

	public void setLicenca(boolean licenca) {
		this.licenca = licenca;
	}
}
