package br.com.carlos_monteiro.teste_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_id")
	private Integer id;

	private String nome;

	private Integer idade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id")
	private Estado estado;

	public Aluno() {
	}

	public Aluno(String nome, int idade, Estado estado) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}

	public Aluno(int id, String nome, int idade, Estado estado) {
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Aluno[ nome:: " + this.nome + " Idade:: " + this.idade + " Estado:: " + this.estado + " Id:: " + this.id
				+ " ]\n";
	}

}
