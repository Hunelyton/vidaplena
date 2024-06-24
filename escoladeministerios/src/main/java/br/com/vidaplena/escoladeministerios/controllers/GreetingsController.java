package br.com.vidaplena.escoladeministerios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    
    
    
}
