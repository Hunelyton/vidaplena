package br.com.vidaplena.escoladeministerios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vidaplena.escoladeministerios.alunos.model.Alunos;
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

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {

		Alunos alunos = new Alunos();
		alunos.setNome(name);

		alunosRepository.save(alunos);

		return "Hello " + name + "!";
	}

	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Alunos>> listaAlunos() {
		List<Alunos> alunos = alunosRepository.findAll();

		return new ResponseEntity<>(alunos, HttpStatus.OK);

	}

	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Alunos> salvar(@RequestBody Alunos alunos) {

		Alunos aluno = alunosRepository.save(alunos);

		return new ResponseEntity<Alunos>(alunos, HttpStatus.CREATED);

	}

	@GetMapping(value = "buscaralunoid")
	@ResponseBody
	public ResponseEntity<Alunos> buscaralunoid(@RequestParam(name = "idaluno") Long idaluno) {

		Alunos aluno = alunosRepository.findById(idaluno).get();

		return new ResponseEntity<Alunos>(aluno, HttpStatus.OK);

	}

	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long idaluno) {

		alunosRepository.deleteById(idaluno);

		return new ResponseEntity<String>("Aluno excluído com sucesso!", HttpStatus.OK);

	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Alunos alunos) {

		if (alunos.getId() == null) {
			return new ResponseEntity<String>("ID do aluno não informado para atualizar o cadastro.", HttpStatus.OK);
		}

		Alunos aluno = alunosRepository.saveAndFlush(alunos);

		return new ResponseEntity<Alunos>(aluno, HttpStatus.OK);

	}

	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Alunos>> buscarPorNome(@RequestParam(name = "name") String name) {

		List<Alunos> aluno = alunosRepository.buscarPorNome(name.trim());

		return new ResponseEntity<List<Alunos>>(aluno, HttpStatus.OK);

	}
	
/*	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		return mv;
		
	}*/
}
