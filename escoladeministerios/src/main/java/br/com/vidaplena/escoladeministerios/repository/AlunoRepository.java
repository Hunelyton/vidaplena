package br.com.vidaplena.escoladeministerios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidaplena.escoladeministerios.alunos.model.Alunos;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long>{

}
