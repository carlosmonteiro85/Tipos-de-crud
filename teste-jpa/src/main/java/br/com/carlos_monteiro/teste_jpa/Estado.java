package br.com.carlos_monteiro.teste_jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estado_id")
	private Integer id;

	private String sigla;

	private String nome;

	@OneToMany(mappedBy = "estado", // mapeando com o atributo estado de Aluno
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Aluno> alunos = new ArrayList<>();

	public Estado() {
	}
	
	public Estado(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigra() {
		return sigla;
	}

	public void setSigra(String sigra) {
		this.sigla = sigra;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Estado [id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", alunos=" + alunos + "]";
	}
}
