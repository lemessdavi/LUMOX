package model;

import java.util.ArrayList;

public class PlanoSemanal {
	private int id;
	private String nome;
	private ArrayList<DiaDaSemana> semana;
	
	public PlanoSemanal(String nome, ArrayList<DiaDaSemana> semana) {
		super();
		this.nome = nome;
		this.semana = semana;
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

	public ArrayList<DiaDaSemana> getSemana() {
		return semana;
	}

	public void setSemana(ArrayList<DiaDaSemana> semana) {
		this.semana = semana;
	}
	
	
}
