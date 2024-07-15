package br.com.vidaplena.escoladeministerios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidaplena.escoladeministerios.model.Alunos;
import br.com.vidaplena.escoladeministerios.repository.AlunoRepository;




/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController

public class GreetingsController {

	@Autowired
	private AlunoRepository alunosRepository;
	

	



	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */

	/**
	 * 
	 * @return
	 */
	
	/* LISTAR ALUNO */
	@GetMapping(value = "listaalunos")
	@ResponseBody
	public ResponseEntity<List<Alunos>> listaAlunos() {
		List<Alunos> alunos = alunosRepository.findAll();

		return new ResponseEntity<>(alunos, HttpStatus.OK);

	}

	/* SALVAR ALUNO */
	@PostMapping(value = "salvaralunos")
	@ResponseBody
	public ResponseEntity<Alunos> salvaralunos(@RequestBody Alunos alunos) {

		Alunos aluno = alunosRepository.save(alunos);

		return new ResponseEntity<Alunos>(alunos, HttpStatus.CREATED);

	}

	/* BUSCAR ALUNO */
	@GetMapping(value = "buscaralunoid")
	@ResponseBody
	public ResponseEntity<Alunos> buscaralunoid(@RequestParam(name = "idaluno") Long idaluno) {

		Alunos aluno = alunosRepository.findById(idaluno).get();

		return new ResponseEntity<Alunos>(aluno, HttpStatus.OK);

	}

	/* DELETAR ALUNO */
	@DeleteMapping(value = "deletealunos")
	@ResponseBody
	public ResponseEntity<String> deletealunos(@RequestParam Long idaluno) {

		alunosRepository.deleteById(idaluno);

		return new ResponseEntity<String>("Aluno excluído com sucesso!", HttpStatus.OK);

	}

	/* ATUALIZAR ALUNO */
	@PutMapping(value = "atualizaralunos")
	@ResponseBody
	public ResponseEntity<?> atualizaralunos(@RequestBody Alunos alunos) {

		if (alunos.getId() == null) {
			return new ResponseEntity<String>("ID do aluno não informado para atualizar o cadastro.", HttpStatus.OK);
		}

		Alunos aluno = alunosRepository.saveAndFlush(alunos);

		return new ResponseEntity<Alunos>(aluno, HttpStatus.OK);

	}

	/* BUSCAR ALUNO */
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Alunos>> buscarPorNome(@RequestParam(name = "name") String name) {

		List<Alunos> aluno = alunosRepository.buscarPorNome(name.trim().toUpperCase());

		return new ResponseEntity<List<Alunos>>(aluno, HttpStatus.OK);

	}
	



}
