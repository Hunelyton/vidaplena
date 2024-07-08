package br.com.vidaplena.escoladeministerios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cadastroaluno")
@Getter
@Setter
public class Alunos {
	
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = true)
	private String cpf;
	
	@Column(length = 20, nullable = true)
	private String telefone;

	@Column(length = 100, nullable = true)
	private String email;
	
	@Column(length = 100, nullable = true)
	private String endereco;
	
	@Column(length = 100, nullable = true)
	private String cep;
	
	@Column(length = 100, nullable = true)
	private String bairro;
	
	@Column(length = 100, nullable = true)
	private String cidade;
	
	@Column(length = 100, nullable = true)
	private String uf;
	
	
	

	
}
