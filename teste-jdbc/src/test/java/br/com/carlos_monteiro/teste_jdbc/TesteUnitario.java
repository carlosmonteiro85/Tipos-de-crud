package br.com.carlos_monteiro.teste_jdbc;

import java.util.Locale;

import com.github.javafaker.Faker;

public abstract class TesteUnitario {
	
	protected static Faker faker = Faker.instance(new Locale("pt", "BR"));

}
