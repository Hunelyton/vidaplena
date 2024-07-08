package br.com.vidaplena.escoladeministerios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vidaplena.escoladeministerios.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {



	
}
