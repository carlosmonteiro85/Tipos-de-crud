package br.com.carlos_monteiro.teste_jdbc;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.carlos_monteiro.teste_jdbc.DAO.AlunoDAO;
import br.com.carlos_monteiro.teste_jdbc.modelo.Aluno;
import br.com.carlos_monteiro.teste_jdbc.modelo.BuilderAluno;
import br.com.carlos_monteiro.teste_jdbc.modelo.Estado;

public class TestePersistencia extends TesteUnitario {

	private Aluno aluno;
	private AlunoDAO service = new AlunoDAO();
	
	/*
	 * Cria um usuario antes do teste
	 * */
	@Before
	public void createAlunoForTest() {
		this.aluno = new BuilderAluno(faker.name().fullName())
				.estado(Estado.DISTRITO_FEDERAL)
				.idade(faker.number().numberBetween(10, 35)).build();
	}

	@Test
	public void insert() {
		// Cenario
		service.insert(aluno);
		// Teste
		Aluno lastAlunoPersisted = getLastAlunoAdd();
		// Validação
		assertTrue(aluno != lastAlunoPersisted);
	}
	
	@Test
	public void update() {
		// Cenario
		service.insert(aluno);
		aluno = getLastAlunoAdd();
		aluno.setNome(faker.name().fullName());
		// Teste
		service.update(aluno);
		Aluno alunoUpdate = service.getById(aluno.getId());
		// Validação
		assertTrue(aluno.getNome().equals(alunoUpdate.getNome()));
	}
	@Test
	public void getAllAlunos() {
		service.insert(aluno);
		List<Aluno> alunos = service.listAll();
		assertTrue(alunos.size() >= 1);
	}
	/*
	 * Deleta os usuarios depois do teste
	 * */
	@After
	public void deleteAlunoTheTest() {
		aluno = getLastAlunoAdd();
		service = new AlunoDAO();
		service.delete(aluno);
	}
//	@Test
	public Aluno getLastAlunoAdd() {
		List<Aluno> alunos = service.listAll();
		Aluno aluno = alunos.get(alunos.size() -1);
		return aluno;
	}

}
