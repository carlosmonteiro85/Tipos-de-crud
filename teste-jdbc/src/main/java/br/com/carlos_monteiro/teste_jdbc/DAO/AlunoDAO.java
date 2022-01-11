package br.com.carlos_monteiro.teste_jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.carlos_monteiro.teste_jdbc.conexao.ConnectionFactory;
import br.com.carlos_monteiro.teste_jdbc.modelo.Aluno;
import br.com.carlos_monteiro.teste_jdbc.modelo.Estado;

public class AlunoDAO {

	public List<Aluno> listAll() {
		List<Aluno> alunos = new ArrayList<>();

		try (Connection con = ConnectionFactory.getConnection()) {

			String sql = "SELECT id , nome, idade, estado  FROM aluno;";

			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String nome = result.getString("nome");
				int idade = result.getInt("idade");
				Estado estado = Estado.getNomeEstado(result.getString("estado"));
//				String estado = result.getString("estado");

				alunos.add(new Aluno(id, nome, idade, estado));
			}

		} catch (SQLException e) {
			System.out.println(" A listagem de alunos falhou");
			e.printStackTrace();
		}

		return alunos;
	}

	public void insert(Aluno aluno) {

		try (Connection con = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO aluno (nome, idade, estado) values (? , ? , ?);";

			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getEstado().toString());

			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Impossivel de inserir");
			e.printStackTrace();
		}

	}

	public void update(Aluno aluno) {

		String sql = "UPDATE aluno SET nome = ?, idade = ? , estado = ? WHERE id = ?";

		try (Connection con = ConnectionFactory.getConnection()) {

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getEstado().toString());
			pstm.setInt(4, aluno.getId());

			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void delete(Aluno aluno) {

		String sql = "DELETE FROM aluno WHERE id = ?";

		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, aluno.getId());

			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Não foi possivel deletar");
			e.printStackTrace();
		}

	}

	public Aluno getById(Integer idAluno) {

		Aluno aluno = new Aluno();

		try (Connection con = ConnectionFactory.getConnection()) {

			String sql = "SELECT id, nome, idade, estado  FROM aluno WHERE id = ? ;";

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, idAluno);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				aluno.setId(result.getInt("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setIdade(result.getInt("idade"));
				aluno.setEstado(Estado.getNomeEstado(result.getString("estado")));
			}

		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a pesquisa do aluno");
			e.printStackTrace();
		}
		return aluno;
	}

}
