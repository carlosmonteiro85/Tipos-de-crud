package br.com.carlos_monteiro.teste_jdbc.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.carlos_monteiro.teste_jpa.Aluno;
import br.com.carlos_monteiro.teste_jpa.dao.AlunoDao;

public class AlunoCrudTest {

	@Test
	public void insertEntityManager() {
		// cenario
		Aluno aluno = createAlunoForTest();
		AlunoDao alunoDAO = new AlunoDao();
		// teste
		alunoDAO.insert(aluno);
		// validação
		assertTrue(aluno.getId() != null);
	}

	@Test
	public void selectById() {
		// cenario
		AlunoDao alunoDAO = new AlunoDao();
		Aluno aluno = createAlunoForTest();
		alunoDAO.insert(aluno);

		// teste
		Aluno alunoObtido = alunoDAO.getById(aluno.getId());

		// validação
		assertTrue(alunoObtido.getId() != null);
	}

	@Test
	public void deletar() {
		AlunoDao alunoDAO = new AlunoDao();
		Aluno aluno = createAlunoForTest();
		alunoDAO.insert(aluno);
		// teste

		alunoDAO.delete(aluno);
	}

	@Test
	public void listAll() {
		AlunoDao alunoDAO = new AlunoDao();
		Aluno aluno = createAlunoForTest();
		alunoDAO.insert(aluno);

		List<Aluno> alunos = alunoDAO.listAll();

		assertTrue(alunos.size() > 0);

	}

	@Test
	public void update() {

		AlunoDao alunoDAO = new AlunoDao();
		Aluno aluno = createAlunoForTest();
		alunoDAO.insert(aluno);

		Aluno alunoAtualizado = alunoDAO.getById(aluno.getId());
		alunoAtualizado.setNome("Aluno Atualizado");
		alunoDAO.update(alunoAtualizado);

		assertEquals(aluno.getId(), alunoAtualizado.getId());

	}

	public Aluno createAlunoForTest() {
		Aluno aluno = new Aluno();
		aluno.setNome("Carlos");
		aluno.setIdade(35);
		return aluno;
	}
}
