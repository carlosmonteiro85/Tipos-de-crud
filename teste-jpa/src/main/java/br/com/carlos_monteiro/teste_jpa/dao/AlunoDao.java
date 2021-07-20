package br.com.carlos_monteiro.teste_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carlos_monteiro.teste_jpa.Aluno;

public class AlunoDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mapeamento-jpa");
	EntityManager em = null;

	public void insert(Aluno aluno) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(aluno);
			em.getTransaction().commit();
			System.out.println("Inserido Com sucesso!");
		} catch (Exception e) {
			System.out.println("Não foi possivel Salvar, causa : " + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Aluno getById(Integer id) {
		em = entityManagerFactory.createEntityManager();
		Aluno aluno = null;
		String sql = "select a from Aluno a WHERE a.id = :id";
		try {
			aluno = (Aluno) em.createQuery(sql, Aluno.class).setParameter("id", id).getSingleResult();
			System.out.println("Obtido entidade: " + aluno.getNome());
		} catch (Exception e) {
			System.out.println("Não foi possivel obter, causa : " + e);
			return null;
		}
		return aluno;
	}

	public void delete(Aluno aluno) {
		em = entityManagerFactory.createEntityManager();
		aluno = getById(aluno.getId());
		em.getTransaction().begin();
		try {
			em.remove(aluno);
			em.getTransaction().commit();
			System.out.println("Deletado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();

		} finally {
			em.close();
		}

	}

	public List<Aluno> listAll() {
		em = entityManagerFactory.createEntityManager();
		List<Aluno> alunos = new ArrayList<Aluno>();

		String sql = "select e from Aluno e";
		try {
			alunos = em.createQuery(sql, Aluno.class).getResultList();
			alunos.forEach(e -> System.out.println(e.getNome()));
		} catch (Exception e) {
			System.out.println("Não foi possivel obter a lista , causa : " + e);
			return alunos;
		}
		return alunos;
	}

	public void update(Aluno aluno) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(aluno);
			em.getTransaction().commit();
			System.out.println("Atualizado Com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Impossível atualizar, causa: ");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
