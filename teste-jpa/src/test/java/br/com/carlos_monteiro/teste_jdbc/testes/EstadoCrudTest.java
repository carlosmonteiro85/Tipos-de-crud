package br.com.carlos_monteiro.teste_jdbc.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.carlos_monteiro.teste_jpa.Estado;
import br.com.carlos_monteiro.teste_jpa.dao.EstadoDAO;

public class EstadoCrudTest {

	@Test
	public void insertEntityManager() {
		// cenario
		Estado estado = createEstadoForTest();
		EstadoDAO estadoDAO = new EstadoDAO();
		// teste
		estadoDAO.insert(estado);
		// validação
		assertTrue(estado.getId() != null);
	}

	@Test
	public void selectById() {
		// cenario
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = createEstadoForTest();
		estadoDAO.insert(estado);

		// teste
		Estado estadoObtido = estadoDAO.getById(estado.getId());

		// validação
		assertTrue(estadoObtido.getId() != null);
	}

	@Test
	public void deletar() {
		Estado estado = createEstadoForTest();
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.insert(estado);
		// teste

		estadoDAO.delete(estado);
	}

	@Test
	public void listAll() {
		Estado estado = createEstadoForTest();

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.insert(estado);

		List<Estado> estados = estadoDAO.listAll();

		assertTrue(estados.size() > 0);

	}

	@Test
	public void update() {

		Estado estado = createEstadoForTest();
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.insert(estado);

		Estado estadoAtualizado = estadoDAO.getById(estado.getId());
		estadoAtualizado.setNome("Distrito Federal");
		estadoDAO.update(estadoAtualizado);

		assertEquals(estado.getId(), estadoAtualizado.getId());

	}

	public Estado createEstadoForTest() {
		Estado estado = new Estado();
		estado.setNome("Brasilia");
		estado.setSigra("DF");
		return estado;
	}
}
