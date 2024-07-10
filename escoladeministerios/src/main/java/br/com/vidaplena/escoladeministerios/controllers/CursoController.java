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

import br.com.vidaplena.escoladeministerios.model.Curso;
import br.com.vidaplena.escoladeministerios.repository.CursoRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */

	/**
	 * 
	 * @return
	 */

	/* LISTAR CURSO */
	@GetMapping(value = "listaCurso")
	@ResponseBody
	public ResponseEntity<List<Curso>> listaCurso() {
		List<Curso> cursos = cursoRepository.findAll();

		return new ResponseEntity<>(cursos, HttpStatus.OK);

	}

	/* SALVAR CURSO */
	@PostMapping(value = "salvarCurso")
	@ResponseBody
	public ResponseEntity<Curso> salvarCurso(@RequestBody Curso cursos) {

		Curso curso = cursoRepository.save(cursos);

		return new ResponseEntity<Curso>(cursos, HttpStatus.CREATED);

	}

	/* BUSCAR CURSO */
	@GetMapping(value = "buscarCursoId")
	@ResponseBody
	public ResponseEntity<Curso> buscarCursoId(@RequestParam(name = "idcurso") Long idcurso) {

		Curso curso = cursoRepository.findById(idcurso).get();

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);

	}

	/* DELETAR CURSO */
	@DeleteMapping(value = "deleteCurso")
	@ResponseBody
	public ResponseEntity<String> deleteCurso(@RequestParam Long idcurso) {

		cursoRepository.deleteById(idcurso);

		return new ResponseEntity<String>("Curso excluído com sucesso!", HttpStatus.OK);

	}

	/* ATUALIZAR CURSO */
	@PutMapping(value = "atualizarCurso")
	@ResponseBody
	public ResponseEntity<?> atualizarCurso(@RequestBody Curso cursos) {

		if (cursos.getId() == null) {
			return new ResponseEntity<String>("ID do curso não informado para atualizar o cadastro.", HttpStatus.OK);
		}

		Curso curso = cursoRepository.saveAndFlush(cursos);

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);

	}



}
