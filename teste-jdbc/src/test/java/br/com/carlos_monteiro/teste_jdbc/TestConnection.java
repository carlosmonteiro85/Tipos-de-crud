package br.com.carlos_monteiro.teste_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Test;

public class TestConnection {

	@Test
	public void testConnection() {

		//CENARIO
		boolean connected = false;
		
		String drive = "mysql";
		String dataBaseAdress = "localhost:3306";
		String dataBaseName = "teste-jdbc?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String senha = "asdf";

		StringBuilder sb = new StringBuilder("jdbc:");

		sb.append(drive).append("://");
		sb.append(dataBaseAdress).append("/");
		sb.append(dataBaseName);

		String connectionURL = sb.toString();

		// TESTE
		try (Connection conn = DriverManager.getConnection(connectionURL, user, senha)) {
			connected = true;
			System.out.println("Sucesso ao se conectar ao BD");
		} catch (Exception e) {
			connected = false;
		}

		// VALIDAÇÃO
		Assert.assertTrue(connected);
	}

}
