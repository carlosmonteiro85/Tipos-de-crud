package br.com.carlos_monteiro.teste_jdbc.modelo;

	
	public final class BuilderAluno {

		protected String nome;
		protected Integer idade;
		protected Estado estado;
		
		public BuilderAluno(String nome) {
			this.nome = nome;
		}

		public BuilderAluno idade(Integer idade) {
			this.idade = idade;
			return this;
		}

		public BuilderAluno estado(Estado estado ) {
			this.estado = estado;
			return this;
		}

		public Aluno build() {
			return new Aluno(this);
		}

}
