package br.com.carlos_monteiro.teste_jdbc.conexao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private ConnectionFactory() {
		throw new UnsupportedOperationException();
	}

	public static Connection getConnection() {

		Connection con = null;

		try (InputStream inputStream = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream("connection.properties")) {

			Properties prop = new Properties();
			prop.load(inputStream);

			String drive = prop.getProperty("jdbc.driver");
			String dataBaseAdress = prop.getProperty("jdbc.base.adress");
			String dataBaseUrl = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.user");
			String senha = prop.getProperty("jdbc.password");

			// construindo a string da connexão
			StringBuilder sb = new StringBuilder("jdbc:");
			sb.append(drive).append("://");
			sb.append(dataBaseAdress).append("/");
			sb.append(dataBaseUrl);

			String connectionURL = sb.toString();

			try {
				con = DriverManager.getConnection(connectionURL, user, senha);
				System.out.println("Sucesso ao se conectar ao BD");
			} catch (SQLException e) {
				System.out.println("Falha ao se conectar no BD");
				throw new RuntimeException(e);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
