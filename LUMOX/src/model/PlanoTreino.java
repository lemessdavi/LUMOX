package model;

import java.util.ArrayList;

public class PlanoTreino {
	
	private int id;
	private String nome;
	private ArrayList<Exercicio> treino;
	
	public PlanoTreino(String nome, ArrayList<Exercicio> treino) {
		super();
		this.nome = nome;
		this.treino = treino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Exercicio> getTreino() {
		return treino;
	}

	public void setTreino(ArrayList<Exercicio> treino) {
		this.treino = treino;
	}
	
	
	
	
	
}
