package br.com.carlos_monteiro.teste_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mapeamento-jpa"	);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Estado estado1 = new Estado("RJ", "Rio de Janeiro");
		Estado estado2 = new Estado("SP", "São Paulo");
		
		Aluno aluno = new Aluno("Carlos ", 35, estado1);
		Aluno aluno2 = new Aluno("Dayane ", 34, estado2);
		Aluno aluno3 = new Aluno("Enzo", 9, estado1);
		Aluno aluno4 = new Aluno("Ana Carla", 6, estado1);
	
		entityManager.getTransaction().begin();
		
		entityManager.persist(estado1);
		entityManager.persist(estado2);
		entityManager.persist(aluno);
		entityManager.persist(aluno2);
		entityManager.persist(aluno3);
		entityManager.persist(aluno4);
		
		entityManager.getTransaction().commit();
		
//		Aluno alunoCarregado = entityManager.find(Aluno.class, 1);
//		
//		System.out.println(alunoCarregado);
///////////////////////////////////////////////////////////////////////////		
//		String sql = "SELECT * FROM aluno WHERE nome = :nome *";
//		
//		Aluno alunoSQL = (Aluno) entityManager
//				.createNativeQuery(sql, Aluno.class)
//				.setParameter(1, nome).getSingleResult();
//	/////////////////////////////////////////////////////////////////////////
		// Consulta de todos SQL query nativa
//		String sql2 = "SELECT * FROM aluno";
//		List<Aluno> alunos = entityManager.createNativeQuery(sql2, Aluno.class).getResultList();
//		alunos.forEach(a -> System.out.println("Consulta SQL de Aluno"+ a));
		
		
//		String jpql = "select a from Aluno a";
//		
//		List<Aluno> alunos= entityManager.createQuery(jpql, Aluno.class).getResultList();
//		
//		System.out.println(alunos);
		
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}
}
