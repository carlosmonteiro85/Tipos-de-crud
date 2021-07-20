package br.com.carlos_monteiro.teste_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTeste {

	public static void main(String[] args) throws SQLException {

		String drive = "postgresql";
		String dataBaseAdress = "127.0.0.1:5432";
		String dataBaseName = "digital_innovation_one";
		String user = "postgres";
		String senha = "asdf";

		//construindo a string da connexão
		StringBuilder sb = new StringBuilder("jdbc:");
			sb.append(drive).append("://");
			sb.append(dataBaseAdress).append("/");
			sb.append(dataBaseName);
		
			String connectionURL = sb.toString();
			
		try (Connection conn = DriverManager.getConnection(connectionURL, user, senha)) {
			System.out.println("Sucesso ao se conectar ao BD");
		} catch (Exception e) {
			System.out.println("Fala ao se conectar no BD");
			e.printStackTrace();
		}

	}

}
