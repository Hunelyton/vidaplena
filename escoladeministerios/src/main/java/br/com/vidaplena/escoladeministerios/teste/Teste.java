package br.com.vidaplena.escoladeministerios.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.vidaplena.escoladeministerios.alunos.model.Alunos;

public class Teste {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		//Find
	//	Alunos alunos = entityManager.find(Alunos.class, 1);
	//	System.out.println("Nome do Aluno: " + alunos.getNome());
	
		// INSERT
		Alunos alunos = new Alunos();
		alunos.setNome("Maria Teste");		
		entityManager.getTransaction().begin();
		entityManager.persist(alunos);
		entityManager.getTransaction().commit();
		
		// DELETE
//		Cliente cliente = entityManager.find(Cliente.class, 2);
//		entityManager.getTransaction().begin();
//		entityManager.remove(alunos);
//		entityManager.getTransaction().commit();
		
		// MODIFY
//		Alunos alunos = new Alunos();
//		alunos.setId(1);
//		alunos.setNome("José dos Santos");
		
//		entityManager.getTransaction().begin();
//		entityManager.merge(alunos);
//		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
