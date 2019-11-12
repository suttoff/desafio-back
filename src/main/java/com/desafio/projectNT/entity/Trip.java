package com.desafio.projectNT.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Viagens")
public class Trip {
	
	Date data = new Date();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String partidaCidade;
	private String partidaEstado;
	private Date partidaDia; 
	private String destinoCidade;
	private String destinoEstado;
	private Date destinoDia;


	

	
	
	
}
