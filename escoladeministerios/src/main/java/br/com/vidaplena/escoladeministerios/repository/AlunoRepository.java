package br.com.vidaplena.escoladeministerios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vidaplena.escoladeministerios.model.Alunos;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long> {
	
	@Query(value="select a from Alunos a where trim(a.nome) like %?1%")
	List<Alunos> buscarPorNome(String name);
	

}
