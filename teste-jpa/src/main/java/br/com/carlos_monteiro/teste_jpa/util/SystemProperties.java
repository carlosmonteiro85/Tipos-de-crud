package br.com.carlos_monteiro.teste_jpa.util;

import java.io.IOException;
import java.util.Properties;

public class SystemProperties {

	private static Properties properties;

	static {
		try {
			properties = new Properties();
			properties.load(SystemProperties.class.getClassLoader().getResourceAsStream("connection.properties"));
			System.out.println(properties.getProperty("base.dir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

}
