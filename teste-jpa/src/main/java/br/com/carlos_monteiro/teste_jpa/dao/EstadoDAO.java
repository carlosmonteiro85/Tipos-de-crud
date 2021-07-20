package br.com.carlos_monteiro.teste_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carlos_monteiro.teste_jpa.Estado;

public class EstadoDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mapeamento-jpa");
	EntityManager em = null;

	public void insert(Estado estado) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(estado);
			em.getTransaction().commit();
			System.out.println("Inserido Com sucesso!");
		} catch (Exception e) {
			System.out.println("Não foi possivel Salvar, causa : " + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Estado getById(Integer id) {
		em = entityManagerFactory.createEntityManager();
		Estado estado = null;
		String sql = "select e from Estado e WHERE e.id = :id";
		try {
			estado = (Estado) em.createQuery(sql, Estado.class).setParameter("id", id).getSingleResult();
			System.out.println("Obtido entidade: " + estado.getNome());
		} catch (Exception e) {
			System.out.println("Não foi possivel obter, causa : " + e);
			return null;
		}
		return estado;
	}

	public void delete(Estado estado) {
		em = entityManagerFactory.createEntityManager();
		estado = getById(estado.getId());
		em.getTransaction().begin();
		try {
			em.remove(estado);
			em.getTransaction().commit();
			System.out.println("Deletado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}

	}

	public List<Estado> listAll() {
		em = entityManagerFactory.createEntityManager();
		List<Estado> estados = new ArrayList<Estado>();

		String sql = "select e from Estado e";
		try {
			estados = em.createQuery(sql, Estado.class).getResultList();
			estados.forEach(e -> System.out.println(e.getNome()));
		} catch (Exception e) {
			System.out.println("Não foi possivel obter a lista , causa : " + e);
			return estados;
		}
		return estados;
	}

	public void update(Estado estado) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(estado);
			em.getTransaction().commit();
			System.out.println("Atualizado Com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Impossível atualizar, causa: ");
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
