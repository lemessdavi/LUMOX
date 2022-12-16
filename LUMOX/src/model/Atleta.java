package model;

import java.sql.SQLException;

import dao.PlanoSemanalDAO;

public class Atleta extends Pessoa {
	
	private PlanoSemanal plano;
	private Avaliacao avaliacao;
	
	public Atleta(String nome, String cpf, String login, String senha) {
		super(nome, cpf, login, senha);
		// TODO Auto-generated constructor stub
	}

	public Atleta(long id, String nome, String cpf, String login, String senha) {
		super(id,nome, cpf, login, senha);
	}

	public Atleta(long id, String nome, String cpf, String login, String senha, PlanoSemanal plano) throws SQLException {
		super(id,nome, cpf, login, senha);
		this.plano = plano;
	}

	public PlanoSemanal getPlano() {
		return plano;
	}


	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	private void atribuirPlano(PlanoSemanal plano) { //mudar para boolean
		this.plano = plano;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
