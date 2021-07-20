package br.com.carlos_monteiro.teste_jpa.conection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carlos_monteiro.teste_jpa.util.SystemProperties;

public class JpaUtil {
	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("nome_mapeamento", getProperties());
	
	public static EntityManager getEM() {
		return emf.createEntityManager();
	}

	public static void close(EntityManager em) {
		em.close();
	}
	
	private static Map<String, Object> getProperties() {
		Map<String, Object> map = new HashMap<>();
		map.put("javax.persistence.jdbc.url", SystemProperties.get("jdbc.url"));
		map.put("javax.persistence.jdbc.driver", SystemProperties.get("jdbc.driver"));
		map.put("javax.persistence.jdbc.user", SystemProperties.get("jdbc.user"));
		map.put("javax.persistence.jdbc.password", SystemProperties.get("jdbc.password"));
		return map;
	}

}
