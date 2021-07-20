package br.com.carlos_monteiro.teste_jdbc.modelo;

public class Aluno {
	
	private Integer id;
	private String nome;
	private Integer idade;
	private String estado;
	
	
	public Aluno() {}
	
	public Aluno(String nome, int idade, String estado) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}
	
	public Aluno(int id, String nome, int idade, String estado) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return "Aluno[ nome:: "+this.nome+ " Idade:: "+this.idade+" Estado:: "+this.estado+ " Id:: " +this.id+" ]\n";
	}
	

}
