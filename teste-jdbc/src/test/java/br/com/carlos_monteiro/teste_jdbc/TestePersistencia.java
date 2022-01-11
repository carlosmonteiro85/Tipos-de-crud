package br.com.carlos_monteiro.teste_jdbc;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.carlos_monteiro.teste_jdbc.DAO.AlunoDAO;
import br.com.carlos_monteiro.teste_jdbc.modelo.Aluno;
import br.com.carlos_monteiro.teste_jdbc.modelo.BuilderAluno;
import br.com.carlos_monteiro.teste_jdbc.modelo.Estado;

public class TestePersistencia extends TesteUnitario {

	private Aluno aluno;
	private AlunoDAO dao;

	@Before
	public void createAlunoForTest() {
		this.aluno = new BuilderAluno(faker.name().fullName())
				.estado(Estado.DISTRITO_FEDERAL)
				.idade(faker.number().numberBetween(10, 35)).build();
	}

	@Test
	public void insert() {
		dao = new AlunoDAO();
		dao.insert(aluno);
		assertTrue(aluno.getId() != null);
	}

//	AlunoDAO dao = new AlunoDAO();
//	Aluno aluno = new Aluno("Carlos ", 35, "DF");
//	
//	//inserindo aluno
//	dao.insert(aluno);	
//	
//	//carregando aluno pelo id
//	Aluno alunoCarregado = dao.getById(13);
//	
//	//setando novo nome para update
//	alunoCarregado.setNome("Nome Atualizado");
//	dao.update(alunoCarregado);
//	
//	Aluno alunoAtualizado = dao.getById(12);
//	//atualizando aluno
//	
//	System.out.println(alunoAtualizado + "\n");
//	
//	//deletando
//	dao.delete(alunoAtualizado);
//	List<Aluno> alunos = dao.listAll();		
//	System.out.println(alunos);

}
