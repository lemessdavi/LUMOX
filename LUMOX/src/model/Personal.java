package model;

import java.util.ArrayList;

public class Personal extends Pessoa {
	
	private ArrayList<Atleta> atletas = new ArrayList();

	public Personal(String nome, String cpf, String login, String senha) {
		super(nome, cpf, login, senha);
	}
	
	public Personal(String nome, String cpf, String login, String senha,ArrayList<Atleta> atletas) {
		super(nome, cpf, login, senha);
		this.atletas = atletas;
	}
	
	public Personal(long id,String nome, String cpf, String login, String senha) {
		super(nome, cpf, login, senha);
		this.id = id;
	}

	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(ArrayList<Atleta> atletas) {
		this.atletas = atletas;
	}
	
	public void atribuirAtleta(Atleta atleta) {
		atletas.add(atleta);
	}
	
	private void criarAvaliacao(Atleta atleta, String avaliacao) { // está boolean no diagrama
		Avaliacao avaliac = new Avaliacao(atleta, avaliacao);
		atleta.setAvaliacao(avaliac);
	}
	private void criarAvaliacao(Avaliacao avaliacao) { // está boolean no diagrama
		avaliacao.getAtleta().setAvaliacao(avaliacao);
	}
	
	

}
