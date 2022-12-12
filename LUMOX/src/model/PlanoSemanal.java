package model;

import java.util.ArrayList;

public class PlanoSemanal {
	private long id;
	private String nome;
	private ArrayList<DiaDaSemana> semana;
	
	public PlanoSemanal(String nome, ArrayList<DiaDaSemana> semana) {
		super();
		this.nome = nome;
		this.semana = semana;
	}
	
	public PlanoSemanal(long id, String nome, ArrayList<DiaDaSemana> semana) {
		super();
		this.id = id;
		this.nome = nome;
		this.semana = semana;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
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
	
	public DiaDaSemana getDiaSemana(int n) {
		return semana.get(n);
	}
}
